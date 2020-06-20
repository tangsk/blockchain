package com.scut.blockchain.contracts;

import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.*;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class KVTableTest extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b506110106000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166356004b6a6040805190810160405280600881526020017f745f6b76746573740000000000000000000000000000000000000000000000008152506040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018060200180602001848103845285818151815260200191508051906020019080838360005b8381101561013957808201518184015260208101905061011e565b50505050905090810190601f1680156101665780820380516001836020036101000a031916815260200191505b50848103835260028152602001807f6964000000000000000000000000000000000000000000000000000000000000815250602001848103825260148152602001807f6974656d5f70726963652c6974656d5f6e616d65000000000000000000000000815250602001945050505050602060405180830381600087803b1580156101ef57600080fd5b505af1158015610203573d6000803e3d6000fd5b505050506040513d602081101561021957600080fd5b810190808051906020019092919050505050610da38061023a6000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063693ec85e14610051578063ed0c8b1714610145575b600080fd5b34801561005d57600080fd5b506100b8600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610212565b604051808415151515815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156101085780820151818401526020810190506100ed565b50505050905090810190601f1680156101355780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561015157600080fd5b506101fc600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506106d6565b6040518082815260200191505060405180910390f35b600080606060008060008060606000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040805190810160405280600881526020017f745f6b76746573740000000000000000000000000000000000000000000000008152506040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156102fd5780820151818401526020810190506102e2565b50505050905090810190601f16801561032a5780820380516001836020036101000a031916815260200191505b5092505050602060405180830381600087803b15801561034957600080fd5b505af115801561035d573d6000803e3d6000fd5b505050506040513d602081101561037357600080fd5b81019080805190602001909291905050509450600093508473ffffffffffffffffffffffffffffffffffffffff1663693ec85e8a6040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156104125780820151818401526020810190506103f7565b50505050905090810190601f16801561043f5780820380516001836020036101000a031916815260200191505b50925050506040805180830381600087803b15801561045d57600080fd5b505af1158015610471573d6000803e3d6000fd5b505050506040513d604081101561048757600080fd5b810190808051906020019092919080519060200190929190505050809450819550505083156106c1578273ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600a8152602001807f6974656d5f707269636500000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561055057600080fd5b505af1158015610564573d6000803e3d6000fd5b505050506040513d602081101561057a57600080fd5b810190808051906020019092919050505091508273ffffffffffffffffffffffffffffffffffffffff16639c981fcb6040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001915050600060405180830381600087803b15801561062d57600080fd5b505af1158015610641573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561066b57600080fd5b81019080805164010000000081111561068357600080fd5b8281019050602081018481111561069957600080fd5b81518560018202830111640100000000821117156106b657600080fd5b505092919050505090505b83828297509750975050505050509193909250565b6000806000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040805190810160405280600881526020017f745f6b76746573740000000000000000000000000000000000000000000000008152506040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156107ba57808201518184015260208101905061079f565b50505050905090810190601f1680156107e75780820380516001836020036101000a031916815260200191505b5092505050602060405180830381600087803b15801561080657600080fd5b505af115801561081a573d6000803e3d6000fd5b505050506040513d602081101561083057600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156108a757600080fd5b505af11580156108bb573d6000803e3d6000fd5b505050506040513d60208110156108d157600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663e942b516886040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260028152602001807f6964000000000000000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b838110156109a4578082015181840152602081019050610989565b50505050905090810190601f1680156109d15780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b1580156109f157600080fd5b505af1158015610a05573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74876040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018381526020018281038252600a8152602001807f6974656d5f70726963650000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b158015610ab157600080fd5b505af1158015610ac5573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e942b516866040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015610b89578082015181840152602081019050610b6e565b50505050905090810190601f168015610bb65780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610bd657600080fd5b505af1158015610bea573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff1663a815ff1588846040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015610ca9578082015181840152602081019050610c8e565b50505050905090810190601f168015610cd65780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015610cf657600080fd5b505af1158015610d0a573d6000803e3d6000fd5b505050506040513d6020811015610d2057600080fd5b810190808051906020019092919050505090507fb103249d88cd818b10c5cd6889874103a7699c5834cb078d8f35925dca8a62d6816040518082815260200191505060405180910390a180935050505093925050505600a165627a7a723058204c092ea6d34ea43e960629f33d7e522a5e7c699d85bb2dd6c70f84c7cbd1016a0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[{\"name\":\"id\",\"type\":\"string\"}],\"name\":\"get\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"item_price\",\"type\":\"int256\"},{\"name\":\"item_name\",\"type\":\"string\"}],\"name\":\"set\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"SetResult\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GET = "get";

    public static final String FUNC_SET = "set";

    public static final Event SETRESULT_EVENT = new Event("SetResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected KVTableTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected KVTableTest(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected KVTableTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected KVTableTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<Tuple3<Boolean, BigInteger, String>> get(String id) {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(new Utf8String(id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple3<Boolean, BigInteger, String>>(
                new Callable<Tuple3<Boolean, BigInteger, String>>() {
                    @Override
                    public Tuple3<Boolean, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<Boolean, BigInteger, String>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> set(String id, BigInteger item_price, String item_name) {
        final Function function = new Function(
                FUNC_SET, 
                Arrays.<Type>asList(new Utf8String(id),
                new Int256(item_price),
                new Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void set(String id, BigInteger item_price, String item_name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SET, 
                Arrays.<Type>asList(new Utf8String(id),
                new Int256(item_price),
                new Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setSeq(String id, BigInteger item_price, String item_name) {
        final Function function = new Function(
                FUNC_SET, 
                Arrays.<Type>asList(new Utf8String(id),
                new Int256(item_price),
                new Utf8String(item_name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, BigInteger, String> getSetInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, BigInteger, String>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getSetOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_SET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public List<SetResultEventResponse> getSetResultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(SETRESULT_EVENT, transactionReceipt);
        ArrayList<SetResultEventResponse> responses = new ArrayList<SetResultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            SetResultEventResponse typedResponse = new SetResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerSetResultEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETRESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerSetResultEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETRESULT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static KVTableTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new KVTableTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static KVTableTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new KVTableTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static KVTableTest load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new KVTableTest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static KVTableTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new KVTableTest(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<KVTableTest> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(KVTableTest.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<KVTableTest> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(KVTableTest.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<KVTableTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(KVTableTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<KVTableTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(KVTableTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class SetResultEventResponse {
        public Log log;

        public BigInteger count;
    }
}
