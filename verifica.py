def is_email_valid(email):
    count_at = 0
    last_dot_index = -1
    last_at_index = -1

    for i in range(len(email)):
        c = email[i]

        if c == '@':
            count_at += 1
            if count_at > 1 or last_dot_index > last_at_index:
                return False  # Mais de um "@" no email ou ponto após o "@".
            last_at_index = i
        elif c == '.':
            if i == last_dot_index + 1 or i == len(email) - 1:
                return False  # Ponto após outro caractere de separação ou ponto no final.
            last_dot_index = i
        elif c == ',':
            return False  # Vírgula não é permitida.

    # Verificar se há pelo menos um "@" e se há pelo menos um ponto antes do último ponto.
    if count_at == 1 and last_dot_index > last_at_index:
        if email.endswith(".br"):
            if not is_domain_valid(email, last_dot_index):
                return False
        return True

    return False  # Formato de e-mail inválido.


def is_domain_valid(email, last_dot_index):
    domain = email[last_dot_index + 1:].lower()
    if domain == "br":
        # Verificar se há um ponto antes do ".br" e, em seguida, algum texto
        if email.rfind(".", 0, last_dot_index - 1) >= 0:
            return True  # Aceitar .br com um domínio anterior

    return False  # Qualquer outro caso é considerado inválido


email = "exemplo@example.com"  # Substitua com o email que deseja verificar

if is_email_valid(email):
    print("O email é válido.")
else:
    print("O email não é válido.")
