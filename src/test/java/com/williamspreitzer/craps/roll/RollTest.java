package com.williamspreitzer.craps.roll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class RollTest {
	
	@Test
	public void testIsAces() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 1;
			mock.die2 = 1;
			assertEquals(1, mock.die);
			assertEquals(1, mock.die2);
			assertTrue(mock.isHardway());
			when(mock.isHardway()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void testCount2WithAces() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 1;
			mock.die2 = 1;
			assertEquals(1, mock.die);
			assertEquals(1, mock.die2);
			assertEquals(2, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test3Count1And2() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 1;
			mock.die2 = 2;
			assertEquals(1, mock.die);
			assertEquals(2, mock.die2);
			assertEquals(3, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test3Count2And1() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 2;
			mock.die2 = 1;
			assertEquals(2, mock.die);
			assertEquals(1, mock.die2);
			assertEquals(3, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test4Count1And3() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 1;
			mock.die2 = 3;
			assertEquals(1, mock.die);
			assertEquals(3, mock.die2);
			assertEquals(4, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}

	@Test
	public void testFourHardwayTrue() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 2;
			mock.die2 = 2;
			assertEquals(2, mock.die);
			assertEquals(2, mock.die2);
			assertTrue(mock.isHardway());
			when(mock.isHardway()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test4CountWithHardway() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 2;
			mock.die2 = 2;
			assertEquals(2, mock.die);
			assertEquals(2, mock.die2);
			assertEquals(4, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test4Count3And1() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 3;
			mock.die2 = 1;
			assertEquals(3, mock.die);
			assertEquals(1, mock.die2);
			assertEquals(4, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test5Count1And4() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 1;
			mock.die2 = 4;
			assertEquals(1, mock.die);
			assertEquals(4, mock.die2);
			assertEquals(5, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test5Count2And3() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 2;
			mock.die2 = 3;
			assertEquals(2, mock.die);
			assertEquals(3, mock.die2);
			assertEquals(5, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test5Count3And2() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 3;
			mock.die2 = 2;
			assertEquals(3, mock.die);
			assertEquals(2, mock.die2);
			assertEquals(5, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test5Count4And1() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 4;
			mock.die2 = 1;
			assertEquals(4, mock.die);
			assertEquals(1, mock.die2);
			assertEquals(5, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test6Count1And5() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 1;
			mock.die2 = 5;
			assertEquals(1, mock.die);
			assertEquals(5, mock.die2);
			assertEquals(6, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test6Count2And4() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 2;
			mock.die2 = 4;
			assertEquals(2, mock.die);
			assertEquals(4, mock.die2);
			assertEquals(6, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void testSixHardwayTrue() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 3;
			mock.die2 = 3;
			assertEquals(3, mock.die);
			assertEquals(3, mock.die2);
			assertTrue(mock.isHardway());
			when(mock.isHardway()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test6CountWithHardway() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 3;
			mock.die2 = 3;
			assertEquals(3, mock.die);
			assertEquals(3, mock.die2);
			assertEquals(6, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test6Count4And2() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 4;
			mock.die2 = 2;
			assertEquals(4, mock.die);
			assertEquals(2, mock.die2);
			assertEquals(6, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test6Count5And1() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 5;
			mock.die2 = 1;
			assertEquals(5, mock.die);
			assertEquals(1, mock.die2);
			assertEquals(6, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}

	@Test
	public void test7Count1And6() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 1;
			mock.die2 = 6;
			assertEquals(1, mock.die);
			assertEquals(6, mock.die2);
			assertEquals(7, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test7Count2And5() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 2;
			mock.die2 = 5;
			assertEquals(2, mock.die);
			assertEquals(5, mock.die2);
			assertEquals(7, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test7Count3And4() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 3;
			mock.die2 = 4;
			assertEquals(3, mock.die);
			assertEquals(4, mock.die2);
			assertEquals(7, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test7Count4And3() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 4;
			mock.die2 = 3;
			assertEquals(4, mock.die);
			assertEquals(3, mock.die2);
			assertEquals(7, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test 
	public void test7Count5And2() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 5;
			mock.die2 = 2;
			assertEquals(5, mock.die);
			assertEquals(2, mock.die2);
			assertEquals(7, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}

	@Test
	public void test7Count6And1() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 6;
			mock.die2 = 1;
			assertEquals(6, mock.die);
			assertEquals(1, mock.die2);
			assertEquals(7, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}

	@Test
	public void test8Count2And6() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 2;
			mock.die2 = 6;
			assertEquals(2, mock.die);
			assertEquals(6, mock.die2);
			assertEquals(8, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test8Count3And5() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 3;
			mock.die2 = 5;
			assertEquals(3, mock.die);
			assertEquals(5, mock.die2);
			assertEquals(8, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void testEightHardwayTrue() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 4;
			mock.die2 = 4;
			assertEquals(4, mock.die);
			assertEquals(4, mock.die2);
			assertTrue(mock.isHardway());
			when(mock.isHardway()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test8CountWithHardway() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 4;
			mock.die2 = 4;
			assertEquals(4, mock.die);
			assertEquals(4, mock.die2);
			assertEquals(8, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}	
	
	@Test
	public void test8Count5And3() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 5;
			mock.die2 = 3;
			assertEquals(5, mock.die);
			assertEquals(3, mock.die2);
			assertEquals(8, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test8Count6And2() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 6;
			mock.die2 = 2;
			assertEquals(6, mock.die);
			assertEquals(2, mock.die2);
			assertEquals(8, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}

	@Test
	public void test9Count3And6() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 3;
			mock.die2 = 6;
			assertEquals(3, mock.die);
			assertEquals(6, mock.die2);
			assertEquals(9, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test9Count4And5() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 4;
			mock.die2 = 5;
			assertEquals(4, mock.die);
			assertEquals(5, mock.die2);
			assertEquals(9, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test9Count5And4() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 5;
			mock.die2 = 4;
			assertEquals(5, mock.die);
			assertEquals(4, mock.die2);
			assertEquals(9, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test9Count6And3() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 6;
			mock.die2 = 3;
			assertEquals(6, mock.die);
			assertEquals(3, mock.die2);
			assertEquals(9, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test10Count4And6() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 4;
			mock.die2 = 6;
			assertEquals(4, mock.die);
			assertEquals(6, mock.die2);
			assertEquals(10, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void testTenHardwayTrue() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 5;
			mock.die2 = 5;
			assertEquals(5, mock.die);
			assertEquals(5, mock.die2);
			assertTrue(mock.isHardway());
			when(mock.isHardway()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void testTenCountWithHardway() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 5;
			mock.die2 = 5;
			assertEquals(5, mock.die);
			assertEquals(5, mock.die2);
			assertEquals(10, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test10Count6And4() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 6;
			mock.die2 = 4;
			assertEquals(6, mock.die);
			assertEquals(4, mock.die2);
			assertEquals(10, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test11Count5And6() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 5;
			mock.die2 = 6;
			assertEquals(5, mock.die);
			assertEquals(6, mock.die2);
			assertEquals(11, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void test11Count6And5() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 6;
			mock.die2 = 5;
			assertEquals(6, mock.die);
			assertEquals(5, mock.die2);
			assertEquals(11, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}

	@Test
	public void testIsBoxCars() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 6;
			mock.die2 = 6;
			assertEquals(6, mock.die);
			assertEquals(6, mock.die2);
			assertTrue(mock.isHardway());
			when(mock.isHardway()).thenCallRealMethod();
		});
		mocked.close();
	}
	
	@Test
	public void testCount12WithBoxCars() {
		MockedConstruction<Roll> mocked = mockConstruction(Roll.class, (mock, context) -> {
			mock.die = 6;
			mock.die2 = 6;
			assertEquals(6, mock.die);
			assertEquals(6, mock.die2);
			assertEquals(12, mock.getCount());
			when(mock.getCount()).thenCallRealMethod();
		});
		mocked.close();
	}
}