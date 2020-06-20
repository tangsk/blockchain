package com.scut.blockchain.contracts;

import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint8;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
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
public class Points extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405260008060006101000a81548160ff021916908360ff1602179055506000600155600060025534801561003557600080fd5b5033600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610dd3806100866000396000f300608060405260043610610083576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806303dd3d81146100885780631a69d4ca14610105578063293120261461015d578063a66e718b146101b8578063d6483d1714610213578063e712a3fa14610290578063fcdbea4f146102eb575b600080fd5b34801561009457600080fd5b506100ef600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061033c565b6040518082815260200191505060405180910390f35b34801561011157600080fd5b5061013a600480360381019080803590602001909291908035906020019092919050505061044d565b604051808381526020018260ff1660ff1681526020019250505060405180910390f35b34801561016957600080fd5b5061019c6004803603810190808035906020019092919080359060200190929190803590602001909291905050506105ac565b604051808260ff1660ff16815260200191505060405180910390f35b3480156101c457600080fd5b506101f7600480360381019080803590602001909291908035906020019092919080359060200190929190505050610747565b604051808260ff1660ff16815260200191505060405180910390f35b34801561021f57600080fd5b5061027a600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506108e2565b6040518082815260200191505060405180910390f35b34801561029c57600080fd5b506102cf6004803603810190808035906020019092919080359060200190929190803590602001909291905050506109f2565b604051808260ff1660ff16815260200191505060405180910390f35b3480156102f757600080fd5b506103206004803603810190808035906020019092919080359060200190929190505050610b8d565b604051808260ff1660ff16815260200191505060405180910390f35b60008060016002540160028190555060025491503390506080604051908101604052808273ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200160008152506005600084815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190610402929190610d02565b506040820151816002015560608201518160030155905050817f25c4e8a67b06969444b6b007448428733f57e750562f66fc6dbb14b34f7fb92360405160405180910390a250919050565b600080600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610515576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4f6e6c792062616e6b2063616e2063616c6c20746869732e000000000000000081525060200191505060405180910390fd5b60016000809054906101000a900460ff16016000806101000a81548160ff021916908360ff1602179055506000809054906101000a900460ff169050826004600086815260200190815260200160002060030160008282540192505081905550429150817f22de4306bb324530648d1d5f80a59aa06352f608abd31215eefce58dbbf7bb2060405160405180910390a29250929050565b600080808073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610653576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f4f6e6c7920637573746f6d65722063616e2063616c6c20746869732e0000000081525060200191505060405180910390fd5b60016000809054906101000a900460ff16016000806101000a81548160ff021916908360ff1602179055506000809054906101000a900460ff1692506005600087815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16915083600560008881526020019081526020016000206003016000828254039250508190555083600560008781526020019081526020016000206003016000828254019250508190555084867ff6294b8d2b45e524e5a4ba77198c5a81fe384965077d4fbe442096d66e133a1860405160405180910390a350509392505050565b600080808073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156107ee576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f4f6e6c7920637573746f6d65722063616e2063616c6c20746869732e0000000081525060200191505060405180910390fd5b60016000809054906101000a900460ff16016000806101000a81548160ff021916908360ff1602179055506000809054906101000a900460ff1692506005600087815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16915083600560008881526020019081526020016000206003016000828254039250508190555083600460008781526020019081526020016000206003016000828254019250508190555084867f965e6404abaa18f870e726c3551412a4bb59266d9dcddb6b5097a04da02ca54860405160405180910390a350509392505050565b600080600180540160018190555060015491503390506080604051908101604052808273ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200160008152506004600084815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190805190602001906109a7929190610d02565b506040820151816002015560608201518160030155905050817f4616270011764c6e73a6a9032e6b236a63c21f1567ed1536ab8da23ea96d9d6160405160405180910390a250919050565b600080808073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a99576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f4f6e6c7920637573746f6d65722063616e2063616c6c20746869732e0000000081525060200191505060405180910390fd5b60016000809054906101000a900460ff16016000806101000a81548160ff021916908360ff1602179055506000809054906101000a900460ff1692506005600087815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16915083600560008881526020019081526020016000206003016000828254019250508190555083600460008781526020019081526020016000206003016000828254039250508190555084867fd6a4c97d96672d4f7f69291457b42c98f57a992985b7bcea346e1b990be41aae60405160405180910390a350509392505050565b600080808073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c34576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f4f6e6c7920636f6d70616e792063616e2063616c6c20746869732e000000000081525060200191505060405180910390fd5b60016000809054906101000a900460ff16016000806101000a81548160ff021916908360ff1602179055506000809054906101000a900460ff1692506004600086815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169150836004600087815260200190815260200160002060030160008282540392505081905550847f5e2694f5885b24fb63d96a6d2ddbc16a65cd19b29d270332ab72ff2d76f6bb3c60405160405180910390a2505092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610d4357805160ff1916838001178555610d71565b82800160010185558215610d71579182015b82811115610d70578251825591602001919060010190610d55565b5b509050610d7e9190610d82565b5090565b610da491905b80821115610da0576000816000905550600101610d88565b5090565b905600a165627a7a7230582050ec7df7837c1d2ca6c55573b365e9ee03eb0d5a9990a80fa334c5c00c592d6c0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"customer_name\",\"type\":\"string\"}],\"name\":\"addCustomer\",\"outputs\":[{\"name\":\"customer_id\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"company_id\",\"type\":\"uint256\"},{\"name\":\"points\",\"type\":\"uint256\"}],\"name\":\"deliverPoints\",\"outputs\":[{\"name\":\"time\",\"type\":\"uint256\"},{\"name\":\"id\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"customer_id1\",\"type\":\"uint256\"},{\"name\":\"customer_id2\",\"type\":\"uint256\"},{\"name\":\"points\",\"type\":\"uint256\"}],\"name\":\"giveAwayPoints\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"customer_id\",\"type\":\"uint256\"},{\"name\":\"company_id\",\"type\":\"uint256\"},{\"name\":\"points\",\"type\":\"uint256\"}],\"name\":\"usePoints\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"company_name\",\"type\":\"string\"}],\"name\":\"addCompany\",\"outputs\":[{\"name\":\"company_id\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"customer_id\",\"type\":\"uint256\"},{\"name\":\"company_id\",\"type\":\"uint256\"},{\"name\":\"points\",\"type\":\"uint256\"}],\"name\":\"getPoints\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"company_id\",\"type\":\"uint256\"},{\"name\":\"points\",\"type\":\"uint256\"}],\"name\":\"acceptPoints\",\"outputs\":[{\"name\":\"id\",\"type\":\"uint8\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"time\",\"type\":\"uint256\"}],\"name\":\"DeliverPoints\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"customer_id1\",\"type\":\"uint256\"},{\"indexed\":true,\"name\":\"customer_id2\",\"type\":\"uint256\"}],\"name\":\"GiveAwayPoints\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"company_id\",\"type\":\"uint256\"},{\"indexed\":true,\"name\":\"customer_id\",\"type\":\"uint256\"}],\"name\":\"UsePoints\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"company_id\",\"type\":\"uint256\"},{\"indexed\":true,\"name\":\"customer_id\",\"type\":\"uint256\"}],\"name\":\"GetPoints\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"company_id\",\"type\":\"uint256\"}],\"name\":\"AcceptPoints\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"company_id\",\"type\":\"uint256\"}],\"name\":\"AddCompany\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"customer_id\",\"type\":\"uint256\"}],\"name\":\"AddCustomer\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_ADDCUSTOMER = "addCustomer";

    public static final String FUNC_DELIVERPOINTS = "deliverPoints";

    public static final String FUNC_GIVEAWAYPOINTS = "giveAwayPoints";

    public static final String FUNC_USEPOINTS = "usePoints";

    public static final String FUNC_ADDCOMPANY = "addCompany";

    public static final String FUNC_GETPOINTS = "getPoints";

    public static final String FUNC_ACCEPTPOINTS = "acceptPoints";

    public static final Event DELIVERPOINTS_EVENT = new Event("DeliverPoints", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event GIVEAWAYPOINTS_EVENT = new Event("GiveAwayPoints", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event USEPOINTS_EVENT = new Event("UsePoints", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event GETPOINTS_EVENT = new Event("GetPoints", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event ACCEPTPOINTS_EVENT = new Event("AcceptPoints", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event ADDCOMPANY_EVENT = new Event("AddCompany", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event ADDCUSTOMER_EVENT = new Event("AddCustomer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected Points(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Points(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Points(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Points(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> addCustomer(String customer_name) {
        final Function function = new Function(
                FUNC_ADDCUSTOMER, 
                Arrays.<Type>asList(new Utf8String(customer_name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addCustomer(String customer_name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDCUSTOMER, 
                Arrays.<Type>asList(new Utf8String(customer_name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addCustomerSeq(String customer_name) {
        final Function function = new Function(
                FUNC_ADDCUSTOMER, 
                Arrays.<Type>asList(new Utf8String(customer_name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getAddCustomerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDCUSTOMER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getAddCustomerOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_ADDCUSTOMER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> deliverPoints(BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_DELIVERPOINTS, 
                Arrays.<Type>asList(new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void deliverPoints(BigInteger company_id, BigInteger points, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DELIVERPOINTS, 
                Arrays.<Type>asList(new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String deliverPointsSeq(BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_DELIVERPOINTS, 
                Arrays.<Type>asList(new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<BigInteger, BigInteger> getDeliverPointsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_DELIVERPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple2<BigInteger, BigInteger> getDeliverPointsOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_DELIVERPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> giveAwayPoints(BigInteger customer_id1, BigInteger customer_id2, BigInteger points) {
        final Function function = new Function(
                FUNC_GIVEAWAYPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id1),
                new Uint256(customer_id2),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void giveAwayPoints(BigInteger customer_id1, BigInteger customer_id2, BigInteger points, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GIVEAWAYPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id1),
                new Uint256(customer_id2),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String giveAwayPointsSeq(BigInteger customer_id1, BigInteger customer_id2, BigInteger points) {
        final Function function = new Function(
                FUNC_GIVEAWAYPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id1),
                new Uint256(customer_id2),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<BigInteger, BigInteger, BigInteger> getGiveAwayPointsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GIVEAWAYPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<BigInteger, BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getGiveAwayPointsOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GIVEAWAYPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> usePoints(BigInteger customer_id, BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_USEPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id),
                new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void usePoints(BigInteger customer_id, BigInteger company_id, BigInteger points, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_USEPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id),
                new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String usePointsSeq(BigInteger customer_id, BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_USEPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id),
                new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<BigInteger, BigInteger, BigInteger> getUsePointsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_USEPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<BigInteger, BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getUsePointsOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_USEPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> addCompany(String company_name) {
        final Function function = new Function(
                FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(new Utf8String(company_name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addCompany(String company_name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(new Utf8String(company_name)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addCompanySeq(String company_name) {
        final Function function = new Function(
                FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(new Utf8String(company_name)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getAddCompanyInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getAddCompanyOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_ADDCOMPANY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> getPoints(BigInteger customer_id, BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_GETPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id),
                new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getPoints(BigInteger customer_id, BigInteger company_id, BigInteger points, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id),
                new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getPointsSeq(BigInteger customer_id, BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_GETPOINTS, 
                Arrays.<Type>asList(new Uint256(customer_id),
                new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<BigInteger, BigInteger, BigInteger> getGetPointsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<BigInteger, BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getGetPointsOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GETPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> acceptPoints(BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_ACCEPTPOINTS, 
                Arrays.<Type>asList(new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void acceptPoints(BigInteger company_id, BigInteger points, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ACCEPTPOINTS, 
                Arrays.<Type>asList(new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String acceptPointsSeq(BigInteger company_id, BigInteger points) {
        final Function function = new Function(
                FUNC_ACCEPTPOINTS, 
                Arrays.<Type>asList(new Uint256(company_id),
                new Uint256(points)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<BigInteger, BigInteger> getAcceptPointsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ACCEPTPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getAcceptPointsOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_ACCEPTPOINTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public List<DeliverPointsEventResponse> getDeliverPointsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DELIVERPOINTS_EVENT, transactionReceipt);
        ArrayList<DeliverPointsEventResponse> responses = new ArrayList<DeliverPointsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DeliverPointsEventResponse typedResponse = new DeliverPointsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.time = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerDeliverPointsEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(DELIVERPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerDeliverPointsEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(DELIVERPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<GiveAwayPointsEventResponse> getGiveAwayPointsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(GIVEAWAYPOINTS_EVENT, transactionReceipt);
        ArrayList<GiveAwayPointsEventResponse> responses = new ArrayList<GiveAwayPointsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            GiveAwayPointsEventResponse typedResponse = new GiveAwayPointsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.customer_id1 = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.customer_id2 = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerGiveAwayPointsEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(GIVEAWAYPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerGiveAwayPointsEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(GIVEAWAYPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<UsePointsEventResponse> getUsePointsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(USEPOINTS_EVENT, transactionReceipt);
        ArrayList<UsePointsEventResponse> responses = new ArrayList<UsePointsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UsePointsEventResponse typedResponse = new UsePointsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.company_id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.customer_id = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerUsePointsEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(USEPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerUsePointsEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(USEPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<GetPointsEventResponse> getGetPointsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(GETPOINTS_EVENT, transactionReceipt);
        ArrayList<GetPointsEventResponse> responses = new ArrayList<GetPointsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            GetPointsEventResponse typedResponse = new GetPointsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.company_id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.customer_id = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerGetPointsEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(GETPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerGetPointsEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(GETPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<AcceptPointsEventResponse> getAcceptPointsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ACCEPTPOINTS_EVENT, transactionReceipt);
        ArrayList<AcceptPointsEventResponse> responses = new ArrayList<AcceptPointsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AcceptPointsEventResponse typedResponse = new AcceptPointsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.company_id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerAcceptPointsEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(ACCEPTPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerAcceptPointsEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(ACCEPTPOINTS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<AddCompanyEventResponse> getAddCompanyEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ADDCOMPANY_EVENT, transactionReceipt);
        ArrayList<AddCompanyEventResponse> responses = new ArrayList<AddCompanyEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AddCompanyEventResponse typedResponse = new AddCompanyEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.company_id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerAddCompanyEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(ADDCOMPANY_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerAddCompanyEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(ADDCOMPANY_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<AddCustomerEventResponse> getAddCustomerEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ADDCUSTOMER_EVENT, transactionReceipt);
        ArrayList<AddCustomerEventResponse> responses = new ArrayList<AddCustomerEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AddCustomerEventResponse typedResponse = new AddCustomerEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.customer_id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerAddCustomerEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(ADDCUSTOMER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerAddCustomerEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(ADDCUSTOMER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static Points load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Points(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Points load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Points(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Points load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Points(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Points load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Points(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Points> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Points.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Points> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Points.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Points> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Points.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Points> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Points.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class DeliverPointsEventResponse {
        public Log log;

        public BigInteger time;
    }

    public static class GiveAwayPointsEventResponse {
        public Log log;

        public BigInteger customer_id1;

        public BigInteger customer_id2;
    }

    public static class UsePointsEventResponse {
        public Log log;

        public BigInteger company_id;

        public BigInteger customer_id;
    }

    public static class GetPointsEventResponse {
        public Log log;

        public BigInteger company_id;

        public BigInteger customer_id;
    }

    public static class AcceptPointsEventResponse {
        public Log log;

        public BigInteger company_id;
    }

    public static class AddCompanyEventResponse {
        public Log log;

        public BigInteger company_id;
    }

    public static class AddCustomerEventResponse {
        public Log log;

        public BigInteger customer_id;
    }
}
