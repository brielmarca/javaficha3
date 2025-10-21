# ficha3 - Exercícios de Cálculo (Java)
# ficha3 - Exercícios de Cálculo (Java)

Programa simples em Java que apresenta um menu interativo com 4 exercícios básicos:

- Perímetro do quadrado (P = 4 * L)
- Converter Celsius → Fahrenheit (F = (C * 1.8) + 32)
- Converter Fahrenheit → Celsius (C = (F - 32) / 1.8)
- Tempo necessário para percorrer uma distância (T = D / V)

O programa `ficha3` é feito para ser usado no terminal. Após cada cálculo é dada a opção de voltar ao menu (pressionando Enter) ou sair do programa (digitando `0` + Enter).

## Arquivo principal

- `ficha3.java` — fonte Java com a classe pública `ficha3`.

## Requisitos

- Java JDK (versão 8 ou superior) instalado e disponível no PATH.

## Como compilar e executar (Windows PowerShell)

1. Abra o PowerShell na pasta que contém `ficha3.java`.
2. Compile:

```powershell
javac "c:\Users\BOLSONARO ANAO\Desktop\ficha 3\ficha3.java"
```

3. Execute:

```powershell
java ficha3
```

Observação: execute os comandos na pasta onde está o arquivo; o caminho acima mostra a localização no exemplo.

## Exemplo de sessão interativa

1. Programa mostra o menu e pede a opção:

```
Escolha uma opção:
1 - Perímetro do quadrado (P = 4 * L)
2 - Converter Celsius para Fahrenheit (F = (C * 1.8) + 32)
3 - Converter Fahrenheit para Celsius (C = (F - 32) / 1.8)
4 - Tempo necessário (T = D / V)
0 - Sair
Opção: _
```

2. Escolha, por exemplo, `1` e pressione Enter. Insira o lado do quadrado quando solicitado e verá o perímetro.

3. Depois do resultado, pressione Enter para voltar ao menu ou digite `0` + Enter para encerrar.

## Limpeza do terminal

O programa tenta limpar o terminal automaticamente (chama `cls` no Windows e `clear` em sistemas Unix). Em alguns ambientes (por exemplo, terminais embutidos em IDEs) essa limpeza pode não ter efeito. Se preferir, posso adicionar uma opção para ativar/desativar a limpeza automática.

## Explicação do código (linha a linha / por blocos)

A seguir um resumo das partes importantes do arquivo `ficha3.java` para ajudar a entender como o programa funciona.

1. Import e declaração da classe

```java
import java.util.Scanner;
public class ficha3 { ... }
```

- `Scanner` é usado para ler entradas do teclado.
- A classe pública `ficha3` contém o método `main` e todos os helpers.

2. Método main

- Cria um `Scanner teclado = new Scanner(System.in);` para ler linhas do teclado.
- Declara a variável `boolean sair = false;` que controla o loop principal.
- Entra num `while (!sair)` que exibe o menu e trata a opção escolhida.

3. Menu e leitura da opção

- O menu é impresso com `System.out.println(...)` exibindo as 5 opções (1..4 e 0 para sair).
- A leitura da opção é feita por `readInt(teclado, "")`. Este método lê uma linha inteira e tenta converter para `int`, repetindo até o usuário digitar um inteiro válido.

4. Cada opção do switch

- case 1 — Perímetro do quadrado
	- Chama `clearConsole()` para limpar a tela.
	- Lê o lado com `readDouble(teclado, "Digite o lado do quadrado: ")`.
	- Calcula `perimetro = 4 * lado` e imprime o resultado.
	- Chama `promptReturnOrExit(teclado)` que espera o usuário pressionar Enter (volta ao menu) ou digitar `0` (sai do programa).

- case 2 — Celsius → Fahrenheit
	- Limpa a tela, lê Celsius (double), converte com `F = C * 1.8 + 32` e imprime com duas casas decimais.
	- Depois chama `promptReturnOrExit`.

- case 3 — Fahrenheit → Celsius
	- Limpa a tela, lê Fahrenheit (double), converte com `C = (F - 32) / 1.8` e imprime com duas casas decimais.
	- Depois chama `promptReturnOrExit`.

- case 4 — Tempo = Distância / Velocidade
	- Limpa a tela, lê distância (km) e velocidade (km/h) com `readDouble`.
	- Se velocidade for zero, mostra uma mensagem de erro evitando divisão por zero.
	- Caso contrário calcula `tempoHoras = distancia / velocidade`, separa em horas e minutos e imprime um resumo como `X horas (H h M min)`.
	- Depois chama `promptReturnOrExit`.

- case 0 — Sair
	- Chama `clearConsole()` e define `sair = true;` para terminar o loop.

5. Helpers importantes

- `readInt(Scanner sc, String prompt)`
	- Lê uma linha inteira com `sc.nextLine()` e tenta converter para `Integer.parseInt`.
	- Em caso de erro de formato, mostra uma mensagem e repete a solicitação.

- `readDouble(Scanner sc, String prompt)`
	- Lê uma linha e usa `Double.parseDouble` para obter um valor double.
	- Repete em caso de entrada inválida.

- `promptReturnOrExit(Scanner sc)`
	- Depois de imprimir um resultado, pergunta: "Pressione Enter para voltar ao menu ou digite 0 e Enter para sair:".
	- Se o usuário digitar `0` retorna `true` (sair); se apenas pressionar Enter retorna `false` (voltar ao menu).

- `clearConsole()`
	- Detecta o sistema operacional com `System.getProperty("os.name")`.
	- No Windows executa `cmd /c cls`, em Unix executa `clear` usando `ProcessBuilder` e `inheritIO()` para que o comando afete a consola atual.
	- Se ocorrer algum erro na execução do comando, o método apenas ignora a exceção para não interromper o programa.

6. Fechamento do Scanner

- Ao final do `main`, antes de encerrar, o programa chama `teclado.close()` para liberar o recurso.

Notas finais:

- O código prioriza interatividade e robustez simples: repete solicitações em entradas inválidas e evita falhas por divisão por zero.
- Se preferir um comportamento diferente (por exemplo: retornar automaticamente ao menu sem pedir confirmação, ou desativar a limpeza da tela), posso adaptar o código e também documentar essa configuração no README.

---

Se quiser, eu também posso adicionar um diagrama rápido do fluxo (menu → opção → cálculo → retorno) ou anotar o arquivo `ficha3.java` com comentários linha a linha diretamente no código.



