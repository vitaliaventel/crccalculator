# crccalculator
CRC16 simple calculation, using next algorithm:

1. Register CRC is stored initial value FFFFh.
2. At the end of the message is added to W zero bits
3. The register is shifted to the left by 1 bit, and the last (zero) position is entered once, not yet processed the data bits.
4. If the register has been promoted with the bit value "1", the contents of the register are combined by XOR with the polynomial. If the bit value is "0", XOR is not performed.
5. Steps 3 and 4 are executed until there are no more data.
6. The final contents of the register are combined by XOR with value FFFFh.