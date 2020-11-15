package challenges.encryption_decryption;

abstract class Decryption {

    protected static StringBuilder decrypt(String mssg, int offset){
        return Encryption.encrypt(mssg, 26 - offset);
    }
}
