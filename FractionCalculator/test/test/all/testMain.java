package test.all;

import java.io.IOException;

import com.calc.Calculator;

import junit.framework.TestCase;

public class testMain extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * ���������е�main����
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void testMain() throws NumberFormatException, IOException {
		Calculator.main(null);			// ����������� 873/234 - 83/72
		Calculator.main(null);			// ����������� 873/234 + 83/72
		Calculator.main(null);			// ����������� 873/234 * 83/72
		Calculator.main(null);			// ����������� 873/234 / 83/72
		Calculator.main(null);			// ����������� (-61/783)^5
		Calculator.main(null);			// ����������� (-61/783)^100
	}
}
