package com.example.SOLIDBankApp2;

import com.example.SOLIDBankApp2.entity.cli.AccountBasicCLI;
import com.example.SOLIDBankApp2.entity.cli.TransactionDepositCLI;
import com.example.SOLIDBankApp2.entity.cli.TransactionWithdrawCLI;
import com.example.SOLIDBankApp2.service.MyCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SolidBankApp2Application implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SolidBankApp2Application.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		boolean running = true;
		String clientID = "1";

		MyCLI myCLI = context.getBean(MyCLI.class);
		AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
		TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
		TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);

		String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
		System.out.printf("Welcome to CLI bank service\n");
		System.out.printf("Enter operation number: \n");
		System.out.printf(helpMessage);
		while(running){
			switch(myCLI.getScanner().nextLine()){
				case "1":
					accountBasicCLI.getAccounts("1");
					break;
				case "2":
					System.out.println("Choose account type: \n[CHECKING, SAVING, FIXED]");
					accountBasicCLI.createAccountRequest("1");
					break;
				case "3":
					transactionDepositCLI.depositMoney(clientID);
					break;
				case "4":
					transactionWithdrawCLI.withdrawMoney(clientID);
					break;
				case "5":
					System.out.println("Transfer has not been released yet.");
					break;
				case "6":
					System.out.printf(helpMessage);
					break;
				case "7":
					System.out.println("Goodbye!");
					running = false;
					break;
				default:
					System.out.println("Command does not exist!");
					break;
			}
		}
		myCLI.getScanner().close();
	}
}
