# Ledger

keytool -genkey -alias 别名 -keypass 密码 -keyalg RSA -keysize 1024 -validity 365 -keystore 路径/密钥.keystore -storepass 密码
keytool -genkey -alias key12345678 -keypass 12345678 -keyalg RSA -keysize 1024 -validity 365 -keystore ./key12345678.keystore -storepass 12345678