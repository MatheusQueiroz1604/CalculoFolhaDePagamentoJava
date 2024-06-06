import java.time.LocalDateTime;
import java.util.Scanner;
import java.lang.Math;

class Main {
  // static final "Tipo de variavel" ("Nome da variavel (Caixa Alta)"); -> Constante
  public static void main(String[] args) {
   
    Scanner console = new Scanner(System.in);
    
    double salarioBruto, porcentagemBruto, insalubridade=0, periculosidade=0, inss=0, fgts=0, irrf=0, planoSaude=0, descontoIRRF=0, aliquotaINSS, aliquotaIRRF, pensaoAlimenticia=0, dependentes=0, salarioLiquido, horasTrabalhadas, salarioDiario, faltas, diasFaltas, diasTrabalhados;
     // essa porcentagem bruto é do vale transporte
    double valeAlimentacao=0, valeTransporte=0, salarioHoras, horasExtras;
    
    String colaborador, empresa, cargo, dataAdmissao, insalubString, valealimString, periculString, planosauString;
    
    System.out.println("Bem Vindo!");

    System.out.println(" ");
    
    System.out.println("Você está no mês: "+ LocalDateTime.now().getMonth()+ " "+ LocalDateTime.now().getYear());

    System.out.println(" ");
    
    System.out.println("Informe os seus dados para que possamos fazer um relatório de todos os seus pagamentos! Todos os dados digitados aqui aparecerão no seu relatório, então lembre-se de ler as perguntas e escrever com atenção (preste atenção na acentuação correta). Para responder as questões de afirmativa, responda: sim / não");
    
    System.out.println(" ");
   
    System.out.println("Digite o nome do colaborador (nome completo): ");
    colaborador = console.nextLine();

    System.out.println(" ");
    
    System.out.println("Qual empresa você trabalha atualmente?: ");
    empresa = console.nextLine();

    System.out.println(" ");
    
    System.out.println("Qual é o seu cargo nessa empresa?: ");
    cargo = console.nextLine();

    System.out.println(" ");

    System.out.println("Digite o sua data de admissão (Coloque no formato dd/MM/yy): ");
    dataAdmissao = console.nextLine();

    System.out.println(" ");
    
    System.out.println("Digite o seu salário bruto (Sem o R$ ex: 1000.00): ");
    salarioBruto = console.nextDouble();

    System.out.println(" ");

    // INSS if else

      if (salarioBruto<=1302.00) {
        inss = salarioBruto * 0.075;
      } else if (salarioBruto<=2571.29) {
        inss = 97.65 + ((salarioBruto - 1302.00)  * 0.09);
      } else if (salarioBruto<=3856.94) {
        inss = 97.65 + 114.24 + ((salarioBruto - 2571.29) * 0.12);
      } else if (salarioBruto<=7507.49) {
        inss = 97.65 + 114.24 + 154.28 + ((salarioBruto - 3856.94) * 0.14);
      } else if (salarioBruto>7507.50) {
        inss = 97.65 + 114.24 + 154.28 + 511.07;
      }
    
    aliquotaINSS = (inss / salarioBruto) * 100;
    
    // Cálculo FGTS
    
    fgts = salarioBruto * 0.08;

    System.out.println("Quantos dias você trabalha por semana? (De 1 a 7): ");
    diasTrabalhados = console.nextDouble();

    System.out.println(" ");
    
    System.out.println("Quantas horas você trabalha por dia?: ");
    horasTrabalhadas = console.nextDouble();

    System.out.println(" ");

    System.out.println("Quantas horas você trabalhou de hora extra este mês? (se nenhuma, digite 0)");
    horasExtras = console.nextDouble();

    System.out.println(" ");

    System.out.println("Quantos dias você faltou esse mês? (se nenhum, digite 0) ");
    diasFaltas = console.nextDouble();

    System.out.println(" ");

    // Insalubridade cálculo
    
    System.out.println("A sua profissão possui aumento por insalubridade? (Sim/Não)");
    insalubString = console.next();
    
    if (insalubString.equalsIgnoreCase("Sim")){
      System.out.println("Qual é o grau de perigo (1-baixo;2-médio;3-alto)");
        int grauPerigo = console.nextInt();
      System.out.println(" ");
         switch (grauPerigo) {
            case 1 :
              insalubridade = salarioBruto * 10 / 100;
              System.out.println("10% adicinais de insalubridade");
              break;
            case 2 :
              insalubridade = salarioBruto * 20 / 100;
              System.out.println("20% adicinais de insalubridade");
              break;
            case 3 :
              insalubridade = salarioBruto * 40 / 100;
              System.out.println("40% adicinais de insalubridade");
              break;
         }
      } if (insalubString.equalsIgnoreCase("Não")) {
      System.out.println(" ");
      System.out.println("Ok, foi selecionado que o seu trabalho não possui insalúbridade!");
      }
    System.out.println(" ");
   
    // Periculosidade cálculo
    
    System.out.println("A sua profissão possui aumento por periculosidade? (Sim/Não)");
    periculString = console.next();
    
    if (periculString.equalsIgnoreCase("Sim")){
      periculosidade = salarioBruto * 30/100;
      System.out.println("30% adicinais de periculosidade");
    } if (periculString.equalsIgnoreCase("Não")) {
      System.out.println(" ");
      System.out.println("Ok, foi selecionado que o seu trabalho não possui periculosidade!");
      }
    System.out.println(" ");
    
    // Vale transporte cálculo
    
    porcentagemBruto = salarioBruto * 6/100;
    
    System.out.println("Quanto você recebe de vale transporte? (ex: 300.00): ");
    valeTransporte = console.nextDouble();
      
    if (valeTransporte<porcentagemBruto){
        valeTransporte = salarioBruto - porcentagemBruto;
    } if (valeTransporte>=porcentagemBruto) {
        valeTransporte = salarioBruto - valeTransporte;
      }
    System.out.println(" ");
    
    // Vale alimentação cálculo
    
    System.out.println("Sua empresa fornece vale alimentação? (Sim/Não)");
    valealimString = console.next();
    
    if (valealimString.equalsIgnoreCase("Sim")){
      System.out.println("Quanto você recebe de vale alimentação? (ex: 30.00): ");
      valeAlimentacao = console.nextDouble();
         valeAlimentacao = (diasTrabalhados * 4) * valeAlimentacao;
         } if (valealimString.equalsIgnoreCase("Não")) {
      System.out.println(" ");
      System.out.println("Ok, foi selecionado que o seu trabalho não fornece vale alimentação");
    }
        System.out.println(" ");

    System.out.println("Você possui plano de saúde? (Sim/Não)");
    planosauString = console.next();
    
    if (planosauString.equalsIgnoreCase("Sim")){
      System.out.println("Quanto custa o seu plano de saúde? (ex: 200.00): ");
      planoSaude = console.nextDouble();
         } if (planosauString.equalsIgnoreCase("Não")) {
      System.out.println(" ");
      System.out.println("Ok, foi selecionado que você nao possui um plano de saúde!");
    }
        System.out.println(" ");
    
    System.out.println("Você possui dependentes? (Sim/Não)");
    String dependentesString = console.next();

       if (dependentesString.equalsIgnoreCase("Sim")){
    System.out.println("Quantos dependentes você possui?: ");
      dependentes = console.nextDouble();
     } if (dependentesString.equalsIgnoreCase("Não")) {
    System.out.println(" ");
    System.out.println("Ok, foi selecionado que você nao possui dependentes!");
    }
    System.out.println(" ");

    System.out.println("Você paga pensão alimenícia? (Sim/Não)");
    String pensaoalimString = console.next();

       if (pensaoalimString.equalsIgnoreCase("Sim")){
    System.out.println("Quanto você paga de pensão (ex: 500): ");
      pensaoAlimenticia = console.nextDouble();
     } if (pensaoalimString.equalsIgnoreCase("Não")) {
    System.out.println(" ");
    System.out.println("Ok, foi selecionado que você nao paga pensão alimentícia!");
    }
    System.out.println(" ");
       
    // Cálculo IRRF

    double irrf2;

    irrf = salarioBruto - inss - pensaoAlimenticia - (dependentes * 189.59);;
    
        // até 1903.98 = isenção
      if (salarioBruto>1903.99) {
        irrf2 = irrf * 0.075;
        descontoIRRF = irrf2 - 142.80;
        aliquotaIRRF = descontoIRRF / salarioBruto;
      } else if (salarioBruto>2826.66) {
        irrf2 = irrf * 0.15;
        descontoIRRF = irrf2 - 354.80;
        aliquotaIRRF = descontoIRRF / salarioBruto;
      } else if (salarioBruto>3751.76) {
        irrf2 = irrf * 0.225;
        descontoIRRF = irrf2 - 636.18;
        aliquotaIRRF = descontoIRRF / salarioBruto;
      } else if (salarioBruto>4664.69) {
        irrf2 = irrf * 0.275;
        descontoIRRF = irrf2 - 869.36;
        aliquotaIRRF = descontoIRRF / salarioBruto;
      }
    salarioHoras = salarioBruto / (4 * diasTrabalhados * horasTrabalhadas);
    
    horasExtras = horasExtras * (salarioHoras * 1.50);

    salarioDiario = salarioBruto / 30;

    faltas = (diasFaltas * salarioDiario);
    
    salarioLiquido = salarioBruto - inss - descontoIRRF - fgts - valeTransporte - valeAlimentacao + insalubridade + periculosidade;

    System.out.println("Tudo pronto para imprimir o relatório!");
    System.out.println(" ");
    System.out.println("==================================================");
    System.out.println(" ");
    System.out.println("Relatório feito em: "+ LocalDateTime.now().getMonth()+ " "+ LocalDateTime.now().getYear());
    System.out.println(" ");
    System.out.println("Nome do colaborador: "+ colaborador);
    System.out.println("Data de admissão: "+ dataAdmissao);
    System.out.println("Cargo do colaborador: "+ cargo+ " - "+ empresa);
    System.out.println(" ");
    System.out.println("Descontos-> Vale transporte: "+ valeTransporte+ "R$");
    System.out.println("Vale alimentação: "+ valeAlimentacao+ "R$");
    System.out.println("FGTS: "+ fgts+ "R$");
    System.out.println("INSS: "+ inss+ "R$");
    System.out.println("IRRF: "+ descontoIRRF+ "R$");
    System.out.println("Faltas:"+ faltas+ "R$");
    System.out.println(" ");
    System.out.println("Proventos-> Insalubridade: "+ insalubridade+ "R$");
    System.out.println("Periculosidade: "+ periculosidade+ "R$");
    System.out.println("Horas extras: "+ horasExtras+ "R$");
    System.out.println(" ");
    System.out.println("Seu salário bruto é: "+ salarioBruto+ "R$");
    System.out.println("Seu salário líquido é: "+ salarioLiquido+ "R$");
    System.out.println("Seu salário por horas é: "+ salarioHoras+ "R$");
    System.out.println(" ");
     System.out.println("==================================================");
   }
}