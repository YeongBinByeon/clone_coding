package ch3.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch3.ExpiryDateCalculator;
import ch3.PayData;

public class ExpiryDateCalculatorTest {

	@Test
	public void ����_�����ϸ�_�Ѵ�_�ڰ�_��������_��() {
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2019, 3, 1))
				.payAmount(10_000)
				.build(),
				LocalDate.of(2019, 4, 1));
		
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2019, 5, 5))
				.payAmount(10_000)
				.build(),
				LocalDate.of(2019, 6, 5));
	}
	
	@Test
	public void �����ϰ�_�Ѵ�_��_���ڰ�_����_����() {

		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2019, 1, 31))
				.payAmount(10_000)
				.build(),
				LocalDate.of(2019, 2, 28));
		
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2019, 5, 31))
				.payAmount(10_000)
				.build(),
				LocalDate.of(2019, 6, 30));
		
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2020, 1, 31))
				.payAmount(10_000)
				.build(),
				LocalDate.of(2020, 2, 29));
		
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2020, 1, 30))
				.payAmount(10_000)
				.build(),
				LocalDate.of(2020, 2, 29));
	}
	
	@Test
	public void ù_�����ϰ�_������_���ڰ�_�ٸ���_����_����() {
		PayData payData = PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 1, 31))
				.billingDate(LocalDate.of(2019, 2, 28))
				.payAmount(10_000)
				.build();
		
		assertExpiryDate(payData, LocalDate.of(2019, 3, 31));
		
		PayData payData2 = PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 1, 30))
				.billingDate(LocalDate.of(2019, 2, 28))
				.payAmount(10_000)
				.build();
		
		assertExpiryDate(payData2, LocalDate.of(2019, 3, 30));
		
		PayData payData3 = PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 5, 31))
				.billingDate(LocalDate.of(2019, 6, 30))
				.payAmount(10_000)
				.build();
		
		assertExpiryDate(payData3, LocalDate.of(2019, 7, 31));
	}
	
	@Test
	public void �̸���_�̻�_�����ϸ�_����ؼ�_������_���() {
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2019, 3, 1))
				.payAmount(20_000)
				.build(),
				LocalDate.of(2019, 5, 1));
		
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2019, 3, 1))
				.payAmount(30_000)
				.build(),
				LocalDate.of(2019, 6, 1));
	}
	
	@Test
	public void ù_�����ϰ�_������_���ڰ�_�ٸ���_�̸���_�̻�_����() {
		assertExpiryDate(
				PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 1, 31))
				.billingDate(LocalDate.of(2019, 2, 28))
				.payAmount(20_000)
				.build(),
				LocalDate.of(2019, 4, 30)
				);
		
		assertExpiryDate(
				PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 1, 31))
				.billingDate(LocalDate.of(2019, 2, 28))
				.payAmount(40_000)
				.build(),
				LocalDate.of(2019, 6, 30)
				);
		
		assertExpiryDate(
				PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 3, 31))
				.billingDate(LocalDate.of(2019, 4, 30))
				.payAmount(30_000)
				.build(),
				LocalDate.of(2019, 7, 31)
				);
	}
	
	@Test
	public void �ʸ�����_�����ϸ�_1��_����() {
		assertExpiryDate(
				PayData.builder()
				.billingDate(LocalDate.of(2019, 1, 28))
				.payAmount(100_000)
				.build(),
				LocalDate.of(2020, 1, 28)
				);
	}

	
	private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
		ExpiryDateCalculator cal = new ExpiryDateCalculator();
		LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
		Assertions.assertEquals(expectedExpiryDate, realExpiryDate);
	}
}
