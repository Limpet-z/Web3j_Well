package root.web3j.core;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class BalancePersonalAcc {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/22d6a5974f25485397c011159543ae95"));
        EthBlockNumber result = web3.ethBlockNumber().sendAsync().get();
        EthGetBalance balance = web3.ethGetBalance("0xb69749D19517b0255985C1a6eCDD05a6307dC30E",
                DefaultBlockParameterName.LATEST).send();


        System.out.println(" The Block Number is: " + result.getBlockNumber().toString());
        System.out.println(Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
        System.exit(1);
    }
}