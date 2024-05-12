package ma.enset.backend.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
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
public class PatientRecord extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b50335f908152600160208190526040909120805460ff19169091179055610bbe806100385f395ff3fe608060405234801561000f575f80fd5b506004361061004a575f3560e01c806307fe5c6b1461004e57806311bd30a11461006357806367c2a36014610092578063b48028e3146100a5575b5f80fd5b61006161005c36600461080c565b6100b8565b005b6100766100713660046108bb565b610353565b6040516100899796959493929190610923565b60405180910390f35b6100616100a0366004610995565b610675565b6100616100b3366004610995565b6106c9565b335f9081526001602052604090205460ff166100ef5760405162461bcd60e51b81526004016100e6906109c2565b60405180910390fd5b5f85511161013f5760405162461bcd60e51b815260206004820152601a60248201527f50617469656e742049442063616e6e6f7420626520656d70747900000000000060448201526064016100e6565b5f8451116101865760405162461bcd60e51b81526020600482015260146024820152734e616d652063616e6e6f7420626520656d70747960601b60448201526064016100e6565b5f83116101d55760405162461bcd60e51b815260206004820152601d60248201527f416765206d7573742062652067726561746572207468616e207a65726f00000060448201526064016100e6565b5f8151116102255760405162461bcd60e51b815260206004820152601960248201527f4950465320686173682063616e6e6f7420626520656d7074790000000000000060448201526064016100e6565b5f6040518060e00160405280878152602001868152602001858152602001848152602001838152602001336001600160a01b03168152602001428152509050805f8760405161027491906109ed565b908152604051908190036020019020815181906102919082610a87565b50602082015160018201906102a69082610a87565b5060408201516002820155606082015160038201906102c59082610a87565b50608082015160048201906102da9082610a87565b5060a08201516005820180546001600160a01b0319166001600160a01b0390921691909117905560c0909101516006909101556040517fa1698454da2bf3265533b0d609aaa7f1a81cee428b9673dd2975b0b433a8467c90610343908890889033904290610b47565b60405180910390a1505050505050565b6060805f6060805f805f808960405161036c91906109ed565b90815260200160405180910390206040518060e00160405290815f8201805461039490610a03565b80601f01602080910402602001604051908101604052809291908181526020018280546103c090610a03565b801561040b5780601f106103e25761010080835404028352916020019161040b565b820191905f5260205f20905b8154815290600101906020018083116103ee57829003601f168201915b5050505050815260200160018201805461042490610a03565b80601f016020809104026020016040519081016040528092919081815260200182805461045090610a03565b801561049b5780601f106104725761010080835404028352916020019161049b565b820191905f5260205f20905b81548152906001019060200180831161047e57829003601f168201915b50505050508152602001600282015481526020016003820180546104be90610a03565b80601f01602080910402602001604051908101604052809291908181526020018280546104ea90610a03565b80156105355780601f1061050c57610100808354040283529160200191610535565b820191905f5260205f20905b81548152906001019060200180831161051857829003601f168201915b5050505050815260200160048201805461054e90610a03565b80601f016020809104026020016040519081016040528092919081815260200182805461057a90610a03565b80156105c55780601f1061059c576101008083540402835291602001916105c5565b820191905f5260205f20905b8154815290600101906020018083116105a857829003601f168201915b505050918352505060058201546001600160a01b0316602082015260069091015460409091015280515190915061063e5760405162461bcd60e51b815260206004820152601860248201527f50617469656e74207265636f7264206e6f7420666f756e64000000000000000060448201526064016100e6565b8051602082015160408301516060840151608085015160a086015160c090960151949e939d50919b50995097509195509350915050565b335f9081526001602052604090205460ff166106a35760405162461bcd60e51b81526004016100e6906109c2565b6001600160a01b03165f908152600160208190526040909120805460ff19169091179055565b335f9081526001602052604090205460ff166106f75760405162461bcd60e51b81526004016100e6906109c2565b336001600160a01b0382160361074f5760405162461bcd60e51b815260206004820152601f60248201527f43616e6e6f74207265766f6b65206f776e20617574686f72697a6174696f6e0060448201526064016100e6565b6001600160a01b03165f908152600160205260409020805460ff19169055565b634e487b7160e01b5f52604160045260245ffd5b5f82601f830112610792575f80fd5b813567ffffffffffffffff808211156107ad576107ad61076f565b604051601f8301601f19908116603f011681019082821181831017156107d5576107d561076f565b816040528381528660208588010111156107ed575f80fd5b836020870160208301375f602085830101528094505050505092915050565b5f805f805f60a08688031215610820575f80fd5b853567ffffffffffffffff80821115610837575f80fd5b61084389838a01610783565b96506020880135915080821115610858575f80fd5b61086489838a01610783565b9550604088013594506060880135915080821115610880575f80fd5b61088c89838a01610783565b935060808801359150808211156108a1575f80fd5b506108ae88828901610783565b9150509295509295909350565b5f602082840312156108cb575f80fd5b813567ffffffffffffffff8111156108e1575f80fd5b6108ed84828501610783565b949350505050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b60e081525f61093560e083018a6108f5565b8281036020840152610947818a6108f5565b9050876040840152828103606084015261096181886108f5565b9050828103608084015261097581876108f5565b6001600160a01b039590951660a0840152505060c0015295945050505050565b5f602082840312156109a5575f80fd5b81356001600160a01b03811681146109bb575f80fd5b9392505050565b6020808252601190820152702ab730baba3437b934bd32b2103ab9b2b960791b604082015260600190565b5f82518060208501845e5f920191825250919050565b600181811c90821680610a1757607f821691505b602082108103610a3557634e487b7160e01b5f52602260045260245ffd5b50919050565b601f821115610a8257805f5260205f20601f840160051c81016020851015610a605750805b601f840160051c820191505b81811015610a7f575f8155600101610a6c565b50505b505050565b815167ffffffffffffffff811115610aa157610aa161076f565b610ab581610aaf8454610a03565b84610a3b565b602080601f831160018114610ae8575f8415610ad15750858301515b5f19600386901b1c1916600185901b178555610b3f565b5f85815260208120601f198616915b82811015610b1657888601518255948401946001909101908401610af7565b5085821015610b3357878501515f19600388901b60f8161c191681555b505060018460011b0185555b505050505050565b608081525f610b5960808301876108f5565b8281036020840152610b6b81876108f5565b6001600160a01b039590951660408401525050606001529291505056fea2646970667358221220c6e3c0e1491750912d267340e7e50958096bbb9f3127f73510016990997748ec64736f6c63430008190033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADDPATIENTRECORD = "addPatientRecord";

    public static final String FUNC_AUTHORIZEUSER = "authorizeUser";

    public static final String FUNC_GETPATIENTRECORD = "getPatientRecord";

    public static final String FUNC_REVOKEAUTHORIZATION = "revokeAuthorization";

    public static final Event PATIENTRECORDADDED_EVENT = new Event("PatientRecordAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected PatientRecord(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PatientRecord(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PatientRecord(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PatientRecord(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<PatientRecordAddedEventResponse> getPatientRecordAddedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PATIENTRECORDADDED_EVENT, transactionReceipt);
        ArrayList<PatientRecordAddedEventResponse> responses = new ArrayList<PatientRecordAddedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            PatientRecordAddedEventResponse typedResponse = new PatientRecordAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.patientId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.addedBy = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static PatientRecordAddedEventResponse getPatientRecordAddedEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PATIENTRECORDADDED_EVENT, log);
        PatientRecordAddedEventResponse typedResponse = new PatientRecordAddedEventResponse();
        typedResponse.log = log;
        typedResponse.patientId = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.addedBy = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        return typedResponse;
    }

    public Flowable<PatientRecordAddedEventResponse> patientRecordAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getPatientRecordAddedEventFromLog(log));
    }

    public Flowable<PatientRecordAddedEventResponse> patientRecordAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PATIENTRECORDADDED_EVENT));
        return patientRecordAddedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addPatientRecord(String _patientId, String _name, BigInteger _age, String _diagnosis, String _ipfsHash) {
        final Function function = new Function(
                FUNC_ADDPATIENTRECORD, 
                Arrays.<Type>asList(new Utf8String(_patientId),
                new Utf8String(_name),
                new Uint256(_age),
                new Utf8String(_diagnosis),
                new Utf8String(_ipfsHash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> authorizeUser(String _user) {
        final Function function = new Function(
                FUNC_AUTHORIZEUSER, 
                Arrays.<Type>asList(new Address(160, _user)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple7<String, String, BigInteger, String, String, String, BigInteger>> getPatientRecord(String _patientId) {
        final Function function = new Function(FUNC_GETPATIENTRECORD, 
                Arrays.<Type>asList(new Utf8String(_patientId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple7<String, String, BigInteger, String, String, String, BigInteger>>(function,
                new Callable<Tuple7<String, String, BigInteger, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple7<String, String, BigInteger, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, BigInteger, String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> revokeAuthorization(String _user) {
        final Function function = new Function(
                FUNC_REVOKEAUTHORIZATION, 
                Arrays.<Type>asList(new Address(160, _user)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PatientRecord load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PatientRecord(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PatientRecord load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PatientRecord(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PatientRecord load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PatientRecord(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PatientRecord load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PatientRecord(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PatientRecord> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PatientRecord.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<PatientRecord> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PatientRecord.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<PatientRecord> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PatientRecord.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<PatientRecord> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PatientRecord.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class PatientRecordAddedEventResponse extends BaseEventResponse {
        public String patientId;

        public String name;

        public String addedBy;

        public BigInteger timestamp;
    }
}
