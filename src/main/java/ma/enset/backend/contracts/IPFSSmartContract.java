package ma.enset.backend.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class IPFSSmartContract extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b506104b68061001c5f395ff3fe608060405234801561000f575f80fd5b506004361061003f575f3560e01c806320b28ade146100435780634e31ad9d14610061578063e1e322ed14610076575b5f80fd5b61004b610089565b604051610058919061021b565b60405180910390f35b61007461006f366004610264565b610127565b005b61004b61008436600461030f565b610184565b335f9081526020819052604090208054606091906100a69061033c565b80601f01602080910402602001604051908101604052809291908181526020018280546100d29061033c565b801561011d5780601f106100f45761010080835404028352916020019161011d565b820191905f5260205f20905b81548152906001019060200180831161010057829003601f168201915b5050505050905090565b335f90815260208190526040902061013f82826103c0565b50336001600160a01b03167f64e6e76f95f944072b8d2f4480943e67dcfa32fcda603d3f231a8213489e977582604051610179919061021b565b60405180910390a250565b5f602081905290815260409020805461019c9061033c565b80601f01602080910402602001604051908101604052809291908181526020018280546101c89061033c565b80156102135780601f106101ea57610100808354040283529160200191610213565b820191905f5260205f20905b8154815290600101906020018083116101f657829003601f168201915b505050505081565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b634e487b7160e01b5f52604160045260245ffd5b5f60208284031215610274575f80fd5b813567ffffffffffffffff8082111561028b575f80fd5b818401915084601f83011261029e575f80fd5b8135818111156102b0576102b0610250565b604051601f8201601f19908116603f011681019083821181831017156102d8576102d8610250565b816040528281528760208487010111156102f0575f80fd5b826020860160208301375f928101602001929092525095945050505050565b5f6020828403121561031f575f80fd5b81356001600160a01b0381168114610335575f80fd5b9392505050565b600181811c9082168061035057607f821691505b60208210810361036e57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f8211156103bb57805f5260205f20601f840160051c810160208510156103995750805b601f840160051c820191505b818110156103b8575f81556001016103a5565b50505b505050565b815167ffffffffffffffff8111156103da576103da610250565b6103ee816103e8845461033c565b84610374565b602080601f831160018114610421575f841561040a5750858301515b5f19600386901b1c1916600185901b178555610478565b5f85815260208120601f198616915b8281101561044f57888601518255948401946001909101908401610430565b508582101561046c57878501515f19600388901b60f8161c191681555b505060018460011b0185555b50505050505056fea26469706673582212203f17f65ed13e94986c0914d80081d78296e2bf7dff30f5a309d72d657a8294dc64736f6c63430008190033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GETIPFSHASH = "getIPFSHash";

    public static final String FUNC_IPFSHASHES = "ipfsHashes";

    public static final String FUNC_STOREIPFSHASH = "storeIPFSHash";

    public static final Event HASHSTORED_EVENT = new Event("HashStored", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected IPFSSmartContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IPFSSmartContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IPFSSmartContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IPFSSmartContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<HashStoredEventResponse> getHashStoredEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(HASHSTORED_EVENT, transactionReceipt);
        ArrayList<HashStoredEventResponse> responses = new ArrayList<HashStoredEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            HashStoredEventResponse typedResponse = new HashStoredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static HashStoredEventResponse getHashStoredEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(HASHSTORED_EVENT, log);
        HashStoredEventResponse typedResponse = new HashStoredEventResponse();
        typedResponse.log = log;
        typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<HashStoredEventResponse> hashStoredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getHashStoredEventFromLog(log));
    }

    public Flowable<HashStoredEventResponse> hashStoredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HASHSTORED_EVENT));
        return hashStoredEventFlowable(filter);
    }

    public RemoteFunctionCall<String> getIPFSHash() {
        final Function function = new Function(FUNC_GETIPFSHASH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ipfsHashes(String param0) {
        final Function function = new Function(FUNC_IPFSHASHES, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> storeIPFSHash(String _ipfsHash) {
        final Function function = new Function(
                FUNC_STOREIPFSHASH, 
                Arrays.<Type>asList(new Utf8String(_ipfsHash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IPFSSmartContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IPFSSmartContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IPFSSmartContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IPFSSmartContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IPFSSmartContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IPFSSmartContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IPFSSmartContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IPFSSmartContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IPFSSmartContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IPFSSmartContract.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IPFSSmartContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IPFSSmartContract.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<IPFSSmartContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IPFSSmartContract.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IPFSSmartContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IPFSSmartContract.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class HashStoredEventResponse extends BaseEventResponse {
        public String user;

        public String ipfsHash;
    }
}
