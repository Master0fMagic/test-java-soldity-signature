// SPDX-License-Identifier: MIT
pragma solidity ^0.8.17;

import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/utils/cryptography/ECDSA.sol";

contract DemoContract {
    struct TestStruct{
        string s1;
        uint256 u2;
        bytes32 b1;
        bytes b2;
    }

    function encodeData(bytes32 b1, string calldata strData, uint256 uVal, address addr, bytes calldata bts)
        external pure returns (bytes memory, bytes32){
            bytes memory hash = abi.encode(
                b1,
                strData,
                uVal,
                addr,
                bts
            );

            bytes32 kck = keccak256(hash);

            return (hash, kck);
    }

    function encodeData(TestStruct memory ts, address addr, uint256 nonce) external  pure returns (bytes memory, bytes32){
        bytes memory hash = abi.encode(
            ts,
            addr,
            nonce
        );

        bytes32 kck = keccak256(hash);

        return (hash, kck);
    }

    function validateSignature(TestStruct memory ts, address addr, uint256 nonce, bytes memory signature)
        external  pure returns (address, ECDSA.RecoverError){
        bytes memory hash = abi.encode(
            ts,
            addr,
            nonce
        );

        bytes32 msgHash = keccak256(hash);

        (address recovered, ECDSA.RecoverError err, ) = ECDSA.tryRecover(msgHash, signature);
        return (recovered, err);
    }
}