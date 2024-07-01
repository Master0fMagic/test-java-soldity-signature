package com.example.soldiity_data_encoding;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.*;
import org.web3j.model.DemoContract;
import org.web3j.utils.Numeric;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MainTests {

    @Test
    void contextLoads() {
    }

    @Test
    void simpleTypesEncoding() {
        byte[] bytes32Data = new byte[32];
        bytes32Data[31] = (byte) 255;

        var stringData = "test string data";
        var u256Data = new Uint256(12345);
        var addrValue = new Address("0xdead");

        var bytesValue = new DynamicBytes(bytes32Data);

        var encodedData = FunctionEncoder.encode("", Arrays.asList(
                        new Bytes32(bytes32Data),
                        new Utf8String(stringData),
                        u256Data,
                        addrValue,
                        bytesValue
                )
        );
        System.out.println(encodedData);

        var hash = Hash.sha3(Numeric.hexStringToByteArray(encodedData));
        var hexHash = Numeric.toHexString(hash);

        System.out.println(hexHash);

        // matched with same test contract value
    }

    @Test
    void testStructDataEncoding() {
        byte[] bytes32Data = new byte[32];
        bytes32Data[31] = (byte) 255;

        var struct = new DemoContract.TestStruct(
                new Utf8String("test string"),
                new Uint256(12345),
                new Bytes32(bytes32Data),
                new DynamicBytes(bytes32Data)
        );


        var encodedData = FunctionEncoder.encode("", Arrays.asList(
                        struct,
                        new Address("0xdead"),
                        new Uint256(12345)
                )
        );
        System.out.println(encodedData);

        var hash = Hash.sha3(Numeric.hexStringToByteArray(encodedData));
        var hexHash = Numeric.toHexString(hash);

        System.out.println(hexHash);

        // matched with same test contract value
    }


    @Test
    void testHDWalletSignature() {
        String derivationPath = "m/0'/2/0/0";

        var seed = "000102030405060708090a0b0c0d0e0f";
        var seedHash = Numeric.hexStringToByteArray(seed);

        // Generate HD Wallet
        Bip32ECKeyPair masterKeypair = Bip32ECKeyPair.generateKeyPair(seedHash);
        Bip32ECKeyPair derivedKeypair = Bip32ECKeyPair.deriveKeyPair(masterKeypair, parseDerivationPath(derivationPath));

        // Get private key
        String privateKey = derivedKeypair.getPrivateKey().toString(16);
        System.out.println("Derived Private Key: " + privateKey);

        ECKeyPair ecKeyPair = ECKeyPair.create(derivedKeypair.getPrivateKey());
        String publicKey = Numeric.toHexStringNoPrefix(ecKeyPair.getPublicKey());
        System.out.println("Public Key: " + publicKey);

        // Derive the Ethereum address from the public key
        String address = Keys.getAddress(ecKeyPair);
        System.out.println("Ethereum Address: 0x" + address);

        // Sample data to sign
        byte[] bytes32Data = new byte[32];
        bytes32Data[31] = (byte) 255;

        System.out.println("bytes data input: " + Numeric.toHexString(bytes32Data) );

        var struct = new DemoContract.TestStruct(
                new Utf8String("test string"),
                new Uint256(12345),
                new Bytes32(bytes32Data),
                new DynamicBytes(bytes32Data)
        );

        var encodedData = FunctionEncoder.encode("", Arrays.asList(
                        struct,
                        new Address("0x" + address),
                        new Uint256(1)
                )
        );
        System.out.println("encoded data to sign" + encodedData);

        var hash = Hash.sha3(Numeric.hexStringToByteArray(encodedData));
        var hexHash = Numeric.toHexString(hash);
        System.out.println("msgHash to sign: " + hexHash);

        // Sign the data
        Sign.SignatureData signature = Sign.signMessage(hash, ecKeyPair, false);

        // Convert signature to HEX
        String r = Numeric.toHexStringNoPrefix(signature.getR());
        String s = Numeric.toHexStringNoPrefix(signature.getS());
        String v = Numeric.toHexStringNoPrefix(signature.getV());

        System.out.println("Signature (r): " + r);
        System.out.println("Signature (s): " + s);
        System.out.println("Signature (v): " + v);

        // Combine r, s, and v into a single byte array
        byte[] rsv = new byte[65];
        System.arraycopy(signature.getR(), 0, rsv, 0, 32);
        System.arraycopy(signature.getS(), 0, rsv, 32, 32);
        System.arraycopy(signature.getV(), 0, rsv, 64, 1);

        // Convert the combined byte array to a hex string
        String rsvHex = Numeric.toHexString(rsv);
        System.out.println("Combined RSV Hex: " + rsvHex);

        //signature verification in contracts passed
    }

    private static int[] parseDerivationPath(String path) {
        String[] components = path.replace("m/", "").split("/");
        int[] result = new int[components.length];

        for (int i = 0; i < components.length; i++) {
            String component = components[i];
            if (component.endsWith("'")) {
                result[i] = Integer.parseInt(component.substring(0, component.length() - 1)) | 0x80000000;
            } else {
                result[i] = Integer.parseInt(component);
            }
        }
        return result;
    }
}
