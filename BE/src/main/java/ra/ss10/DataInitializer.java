package ra.ss10;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ra.ss10.entity.model.Account;
import ra.ss10.entity.model.Status;
import ra.ss10.repository.AccountRepository;

import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataInitializer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (accountRepository.count() == 0) {
            Account a1 = new Account();
            a1.setId(UUID.randomUUID());
            a1.setFullName("Nguyen Thanh Nam");
            a1.setEmail("nam@gmail.com");
            a1.setPassword("123456");
            a1.setCccd("001234567890");
            a1.setPhone("0912345678");
            a1.setMoney(5000000.0);
            a1.setStatus(Status.ACTIVE);

            Account a2 = new Account();
            a2.setId(UUID.randomUUID());
            a2.setFullName("Tran Thi Bich");
            a2.setEmail("bich@gmail.com");
            a2.setPassword("123456");
            a2.setCccd("001234567891");
            a2.setPhone("0987654321");
            a2.setMoney(2000000.0);
            a2.setStatus(Status.ACTIVE);

            Account a3 = new Account();
            a3.setId(UUID.randomUUID());
            a3.setFullName("Le Van Cuong");
            a3.setEmail("cuong@gmail.com");
            a3.setPassword("123456");
            a3.setCccd("001234567892");
            a3.setPhone("0901234567");
            a3.setMoney(3500000.0);
            a3.setStatus(Status.INACTIVE);

            accountRepository.save(a1);
            accountRepository.save(a2);
            accountRepository.save(a3);

            System.out.println(">>> Da tao 3 tai khoan mau thanh cong!");
        } else {
            System.out.println(">>> Du lieu da ton tai, bo qua khoi tao.");
        }
    }
}
