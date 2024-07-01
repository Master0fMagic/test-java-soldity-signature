package org.web3j.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.11.3.
 */
@SuppressWarnings("rawtypes")
public class DemoContract extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b506105058061001c5f395ff3fe608060405234801561000f575f80fd5b5060043610610034575f3560e01c8063dbd8f19e14610038578063e8e4dae714610062575b5f80fd5b61004b61004636600461015b565b610075565b60405161005992919061021b565b60405180910390f35b61004b610070366004610315565b6100be565b60605f80898989898989896040516020016100969796959493929190610416565b60408051808303601f1901815291905280516020820120909b909a5098505050505050505050565b60605f808585856040516020016100d793929190610466565b60408051808303601f19018152919052805160208201209097909650945050505050565b5f8083601f84011261010b575f80fd5b50813567ffffffffffffffff811115610122575f80fd5b602083019150836020828501011115610139575f80fd5b9250929050565b80356001600160a01b0381168114610156575f80fd5b919050565b5f805f805f805f60a0888a031215610171575f80fd5b87359650602088013567ffffffffffffffff81111561018e575f80fd5b61019a8a828b016100fb565b909750955050604088013593506101b360608901610140565b9250608088013567ffffffffffffffff8111156101ce575f80fd5b6101da8a828b016100fb565b989b979a50959850939692959293505050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b604081525f61022d60408301856101ed565b90508260208301529392505050565b634e487b7160e01b5f52604160045260245ffd5b6040516080810167ffffffffffffffff811182821017156102735761027361023c565b60405290565b5f8067ffffffffffffffff8411156102935761029361023c565b50604051601f19601f85018116603f0116810181811067ffffffffffffffff821117156102c2576102c261023c565b6040528381529050808284018510156102d9575f80fd5b838360208301375f60208583010152509392505050565b5f82601f8301126102ff575f80fd5b61030e83833560208501610279565b9392505050565b5f805f60608486031215610327575f80fd5b833567ffffffffffffffff81111561033d575f80fd5b84016080818703121561034e575f80fd5b610356610250565b813567ffffffffffffffff81111561036c575f80fd5b8201601f8101881361037c575f80fd5b61038b88823560208401610279565b8252506020828101359082015260408083013590820152606082013567ffffffffffffffff8111156103bb575f80fd5b6103c7888285016102f0565b60608301525093506103dd905060208501610140565b929592945050506040919091013590565b81835281816020850137505f828201602090810191909152601f909101601f19169091010190565b87815260a060208201525f61042f60a08301888a6103ee565b604083018790526001600160a01b038616606084015282810360808401526104588185876103ee565b9a9950505050505050505050565b606081525f84516080606084015261048160e08401826101ed565b905060208601516080840152604086015160a08401526060860151605f198483030160c08501526104b282826101ed565b6001600160a01b039690961660208501525050506040015291905056fea2646970667358221220ac3057753fac46d191aca5e87a856a074b67067664fa241eb143cbed238a337f64736f6c634300081a0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_encodeData = "encodeData";

    @Deprecated
    protected DemoContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DemoContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DemoContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DemoContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple2<DynamicBytes, Bytes32>> encodeData(Bytes32 b1, Utf8String strData, Uint256 uVal, Address addr, DynamicBytes bts) {
        final Function function = new Function(FUNC_encodeData, 
                Arrays.<Type>asList(b1, strData, uVal, addr, bts), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple2<DynamicBytes, Bytes32>>(function,
                new Callable<Tuple2<DynamicBytes, Bytes32>>() {
                    @Override
                    public Tuple2<DynamicBytes, Bytes32> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<DynamicBytes, Bytes32>(
                                (DynamicBytes) results.get(0), 
                                (Bytes32) results.get(1));
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<DynamicBytes, Bytes32>> encodeData(TestStruct ts, Address addr, Uint256 nonce) {
        final Function function = new Function(FUNC_encodeData, 
                Arrays.<Type>asList(ts, addr, nonce), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple2<DynamicBytes, Bytes32>>(function,
                new Callable<Tuple2<DynamicBytes, Bytes32>>() {
                    @Override
                    public Tuple2<DynamicBytes, Bytes32> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<DynamicBytes, Bytes32>(
                                (DynamicBytes) results.get(0), 
                                (Bytes32) results.get(1));
                    }
                });
    }

    @Deprecated
    public static DemoContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DemoContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DemoContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DemoContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DemoContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DemoContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DemoContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DemoContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DemoContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DemoContract.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<DemoContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DemoContract.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<DemoContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DemoContract.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<DemoContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DemoContract.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class TestStruct extends DynamicStruct {
        public Utf8String s1;

        public Uint256 u2;

        public Bytes32 b1;

        public DynamicBytes b2;

        public TestStruct(Utf8String s1, Uint256 u2, Bytes32 b1, DynamicBytes b2) {
            super(s1, u2, b1, b2);
            this.s1 = s1;
            this.u2 = u2;
            this.b1 = b1;
            this.b2 = b2;
        }
    }
}
