// Define os niveis fixos possiveis da Formacao
// enum -> Conjunto fechado de opcoes para o nível da formacao (nao aceita qualquer texto)
enum class Nivel { Basico, Intermediario, Avancado }

// Representa um Conteudo Educacional (aulas, projetos, materiais, etc)
data class ConteudoEducacional(val nome: String, val cargaHoraria: Int)

// Representa um Aluno (nome e id)
data class Aluno(val id: String, val nome: String)

// Representa a Formacao (nome, nivel e lista de conteudos, alem de suas funcoes)
class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableSet<ConteudoEducacional>){

    // Alunos Inscritos e Cancelados sao armanezados em um set para garantir que nao existiram duplicados
    
	// Alunos matriculados
    val inscritos = mutableSetOf<Aluno>()

    // Alunos que cancelaram a matricula
    val cancelados = mutableSetOf<Aluno>()

    // Efetua matricula de um aluno ou de uma lista de alunos
    fun matricular(vararg alunos: Aluno) { 
        
        // Cria uma copia da lista de alunos ja inscritos
        val jaSaoAlunos = inscritos.toSet()
        
        // Adiciona todos os alunos recebidos no Set de inscritos 
        inscritos.addAll(alunos)
        
        // Cria uma lista dos alunos recebidos excluindo os alunos que ja estavam cadastrados na lista atual
        val novosAlunos = inscritos.subtract(jaSaoAlunos)
        
        // Imprime um cabecalho para mostrar os novos alunos matriculados
        println ("LISTA DE ALUNOS NOVOS MATRICULADOS")
        println ("")
        
        // Se for um novo aluno, imprime na tela
        for (novoAluno in novosAlunos)
        {
    		println("-> Aluno: ${novoAluno.nome}, ID: ${novoAluno.id} foi matriculado no curso: ${this.nome}")
        }
        println ("")
    }

    // Cancela matricula de um aluno ou de uma lista de alunos
    fun cancelarMatricula(vararg alunos: Aluno) { 
        
        // Percorre a lista de alunos que cancelaram sua matricula
        for (cancelado in alunos)
        {
            // Remove o aluno que cancelou sua matricula da lista de inscritos
            // remove -> Retorna true se o aluno estava matriculado e foi removido agora
            if (inscritos.remove(cancelado))
            {
                // Adiciona o aluno que teve sua matricula cancelada no Set de cancelados
                cancelados.add(cancelado)
                
                // Imprime um cabecalho para mostrar os alunos que tiveram sua matricula cancelada
                println ("LISTA DE ALUNOS COM MATRICULA CANCELADA")
                println ("")
                        
                // Imprime o aluno que teve a matricula cancelada na tela
	            println("Aluno: ${cancelado.nome}, ID: ${cancelado.id} teve sua matricula cancelada no curso: ${this.nome}")
            }
    	}
        println("")
    }

    // Funcao para adicionar Conteudos Educacionais a uma Formacao
    // Permite adicionar um unico conteudo ou uma lista de conteudos
    fun addConteudo(vararg novosConteudos: ConteudoEducacional){
 
        // Criar variavel de verificacao se algum conteudo foi adicionado a alguma Formacao
        var adicionou = false

        // Lista de ConteudosEducacionais duplicados
  		val conteudosDuplicados = mutableSetOf<ConteudoEducacional>()
            
		// Percorre todos os conteudos recebidos na vararg
        for (novoConteudo in novosConteudos){           

            // Se conteudo foi adicionado, informa na tela
            // add -> retorna true se adicionou conteudo, ou false se era duplicado
            if (conteudos.add(novoConteudo)) {
				
				// Imprime o cabecalho se adicionou for false
                if (!adicionou){
                	
                    // Imprime um cabecalho para mostrar os novos conteudos adicionados a Formacao
    	    		println ("LISTA DE CONTEUDOS ADICIONADOS")
        			println ("")
					
					// Muda a variavel para true para nao imprimir novamente
                    adicionou = true
                }
                
                // Imprime o conteudo que foi adicionado e em qual formacao
                println("-> ${novoConteudo.nome} adicionado a Formacao: $nome")
            }
            // Se era duplicado, adiciona a lista de duplicados
            else {
            	conteudosDuplicados.add(novoConteudo)
            }
            
            // Verifica se existiu conteudo duplicado e imprime
            if (conteudosDuplicados.isNotEmpty()){
                 // Imprime um cabecalho para mostrar os conteudos que nao foram adicionados porque ja faziam parte da Formacao
                println ("LISTA DE CONTEUDOS NAO ADICIONADOS PORQUE JA FAZEM PARTE DA FORMACAO")
                println ("")
                
                for ( conteudoDuplicado in conteudosDuplicados){
                	println("-> ${conteudoDuplicado.nome} ja consta na Formacao: $nome")    
                }
            }
        }   
        println("")
    }

    // Calcula a carga horaria total da formacao somando a carga horaria de todos os conteudos 
    fun cargaHorariaFormacao(): Int {
        
        // Inicializar variavel com 0
        var cargaHorariaTotal = 0
        
        // Percorre todo o Set de Conteudo Educacional existente
        for (conteudo in conteudos){
            
            // Soma a carga horario de todos os conteudos de uma formacao
            cargaHorariaTotal += conteudo.cargaHoraria
        }

        // Retorna a soma da carga horario de uma formacao
        return cargaHorariaTotal
        println("")
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
