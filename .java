public class VerificarEmail {
    public static boolean isEmailValid(String email) {
        int countAt = 0;
        int lastDotIndex = -1;
        int lastAtIndex = -1;

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);

            if (c == '@') {
                countAt++;
                if (countAt > 1 || lastDotIndex > lastAtIndex) {
                    return false; // Mais de um "@" no email ou ponto após o "@".
                }
                lastAtIndex = i;
            } else if (c == '.') {
                if (i == lastDotIndex + 1 || i == email.length() - 1) {
                    return false; // Ponto após outro caractere de separação ou ponto no final.
                }
                lastDotIndex = i;
            } else if (c == ',') {
                return false; // Vírgula não é permitida.
            }
        }

        // Verificar se há pelo menos um "@" e se há pelo menos um ponto antes do último ponto.
        if (countAt == 1 && lastDotIndex > lastAtIndex) {
            if (email.endsWith(".br")) {
                if (!isDomainValid(email, lastDotIndex)) {
                    return false;
                }
            }
            return true;
        }
        return false; // Formato de e-mail inválido.
    }

    public static boolean isDomainValid(String email, int lastDotIndex) {
        String domain = email.substring(lastDotIndex + 1).toLowerCase(); // Converter para minúsculas para evitar problemas de sensibilidade a maiúsculas e minúsculas
        if (domain.equals("br")) {
            // Verificar se há um ponto antes do ".br" e, em seguida, algum texto
            if (email.lastIndexOf(".", lastDotIndex - 1) >= 0) {
                return true; // Aceitar .br com um domínio anterior
            }
        }
        return false; // Qualquer outro caso é considerado inválido
    }

    public static void main(String[] args) {
        String email = "exemplo@example.com"; // Substitua com o email que deseja verificar

        if (isEmailValid(email)) {
            System.out.println("O email é válido.");
        } else {
            System.out.println("O email não é válido.");
        }
    }
}
