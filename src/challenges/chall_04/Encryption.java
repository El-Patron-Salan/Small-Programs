package challenges.chall_04;

abstract class Encryption {

    protected static StringBuilder encrypt(String input, int offset) {

        StringBuilder sb = new StringBuilder();

        if(offset > 26)
            offset %= 26;
        //when shift is negative
        else if(offset < 0)
            offset = (offset % 26) + 26;

        for (char character : input.toCharArray()) {
            if(character != ' '){
                //get actual position in alphabet and make a scope from 0 to 25
                int positionChar = character - 'a';
                //remain in scope of alphabet
                int newPosition = (positionChar + offset) % 26;
                //return to ascii table and take value
                char newCharacter = (char) (newPosition + 'a');

                sb.append(newCharacter);
            }
            else
                sb.append(character);
        }
        return sb;
    }
}
