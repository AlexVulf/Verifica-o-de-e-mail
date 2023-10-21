import javax.swing.JOptionPane;

public class validacaoDeEmail {

	public static void main(String[] args) {
		String email = JOptionPane.showInputDialog("Digite o Email ");
		
		int posicaoUltimoPnto = email.lastIndexOf(".");
		
		boolean emailValido = email.contains("@")
				&& email.charAt(email.lastIndexOf("@")+1) != '.'
				&& posicaoUltimoPnto > (email.lastIndexOf("@")+1)
				&& posicaoUltimoPnto != (email.length()-1);
		if (emailValido) {
			JOptionPane.showMessageDialog(null, "O email é válido.");
        } else {
        	JOptionPane.showMessageDialog(null, "O email não é válido.");
        }

	}

}
