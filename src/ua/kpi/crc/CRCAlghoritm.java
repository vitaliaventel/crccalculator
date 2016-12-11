package ua.kpi.crc;

public class CRCAlghoritm {

	private static final int CRC16_LEN = 16;
	private static final int CRC16_POLY = 0x8005;
	private static final int CRC16_INIT = 0xFFFF;
	private static final int CRC32_LEN = 32;
	private static final int CRC32_POLY = 0x4C11DB7;
	private static final int CRC32_INIT = 0xFFFFFFFF;
	private static final int BYTE_SIZE = 8;

	public static String crc16(String data) {
		int crc = CRC16_INIT;
		byte[] binarySet = data.getBytes();
		for (byte binaryData : binarySet) {
			int message = binaryData;
			for (int i = 1; i <= BYTE_SIZE; i++) {
				int mask = 1 << (BYTE_SIZE - i);
				if ((crc & 0x8000) != 0) {
					if ((mask & message) != 0) {
						crc <<= 1;
						crc |= 1;
						crc &= CRC16_INIT;
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
						crc &= CRC16_INIT;
					} else {
						crc <<= 1;
						crc &= 0xFFFE;
					}
				}
			}
		}
		for (int i = 1; i <= CRC16_LEN; i++) {
			if ((crc & 0x8000) != 0) {
				crc <<= 1;
				crc &= 0xFFFE;
				crc ^= CRC16_POLY;
				crc &= CRC16_INIT;
			} else {
				crc <<= 1;
				crc &= 0xFFFE;
			}
		}

		crc ^= CRC16_INIT;
		return Integer.toHexString(crc).toUpperCase();
	}

	public static String crc32(String data) {
		int crc = CRC32_INIT;
		byte[] binarySet = data.getBytes();
		for (byte binaryData : binarySet) {
			int message = binaryData;
			for (int i = 1; i <= BYTE_SIZE; i++) {
				int mask = 1 << (BYTE_SIZE - i);
				if ((crc & 0x80000000) != 0) {
					if ((mask & message) != 0) {
						crc <<= 1;
						crc |= 1;
						crc &= CRC32_INIT;
					} else {
						crc <<= 1;
						crc &= 0xFFFFFFFE;
					}
					crc ^= CRC32_POLY;
					crc &= CRC32_INIT;
				} else {
					if ((mask & message) != 0) {
						crc <<= 1;
						crc |= 1;
						crc &= CRC32_INIT;
					} else {
						crc <<= 1;
						crc &= 0xFFFFFFFE;
					}
				}
			}
		}
		for (int i = 1; i <= CRC32_LEN; i++) {
			if ((crc & 0x80000000) != 0) {
				crc <<= 1;
				crc &= 0xFFFFFFFE;
				crc ^= CRC32_POLY;
				crc &= CRC32_INIT;
			} else {
				crc <<= 1;
				crc &= 0xFFFFFFFE;
			}
		}

		crc ^= CRC32_INIT;
		return Integer.toHexString(crc).toUpperCase();
	}

}
