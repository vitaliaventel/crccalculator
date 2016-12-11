package ua.kpi.crc;

public class CRCAlghoritm {

	private static int BITS_NUM = 16;
	private static int CRC16_POLY = 0x8005;

	public static String crc16(String data) {
		int crc = 0xFFFF;
		byte[] binarySet = data.getBytes();
		for (byte binaryData : binarySet) {
			String binary = Integer.toBinaryString(binaryData);
			System.out.println(binary + " " + binary.length());
			int len = binary.length();
			int message = Integer.parseInt(binary, 2);
			message <<= BITS_NUM;
			System.out.println("MSG - " + Integer.toBinaryString(message));
			for (int i = 1; i <= (BITS_NUM + len); i++) {
				System.out.println("CRC - " + Integer.toBinaryString(crc));
				int mask = 1 << (BITS_NUM + len - i);
				System.out.println("MASK - " + Integer.toBinaryString(mask));
				if ((crc & 0x8000) != 0) {
					if ((mask & message) != 0) {
						crc <<= 1;
						crc |= 1;
						crc &= 0xFFFF;
					} else {
						crc <<= 1;
						crc &= 0xFFFE;
					}
					crc ^= CRC16_POLY;
					crc &= 0xFFFF;
				} else {
					if ((mask & message) != 0) {
						crc <<= 1;
						crc |= 1;
						crc &= 0xFFFF;
					} else {
						crc <<= 1;
						crc &= 0xFFFE;
					}
				}
				System.out.println("CRC - " + Integer.toBinaryString(crc));
			}
		}
		crc ^= 0xFFFF;
		return Integer.toHexString(crc).toUpperCase();
	}

}
