package challenges.chall_04;

abstract class Decryption {

    protected static StringBuilder decrypt(String mssg, int offset){
        return Encryption.encrypt(mssg, 26 - offset);
    }
}
