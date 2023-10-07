import java.time.LocalDate
import java.time.Month

fun main() {
//    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val videoLink = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    val documentLink = "https://www.google.com/"

    val genericQuestionList = listOf(
            Question(
                "Qual a coisa?",
                "a",
                mapOf(
                    "a" to "coisa 1",
                    "b" to "coisa 2",
                    "c" to "coisa 3",
                    "d" to "coisa 4",
                    "e" to "coisa 5",
            )
        )
    )

    val genericQuestion = Content.Test(
        "Teste seu conhecimento",
        genericQuestionList
    )

    val ecIntroKotlinSection1 = EducationalContent.Section(
        "Configuração de Ambiente",
        listOf(
            Content.Video("Instalação", videoLink),
            Content.Video("VsCode", videoLink),
            Content.Video("Intellij", videoLink),
        )
    )

    val ecIntroKotlinSection2 = EducationalContent.Section(
        "Codificação",
        listOf(
            Content.Video("Variáveis", videoLink),
            Content.Video("Loops e condições", videoLink),
            Content.Video("Funções", videoLink),
            Content.Document("Documentação", documentLink),
            genericQuestion
        )
    )

    val ecIntroKotlin = EducationalContent(
        "Introdução Prática à Linguagem de Programação Kotlin",
        2,
        Level.BASIC,
        listOf(ecIntroKotlinSection1,)

    )

    val ecsKnowKotlinSection1 = EducationalContent.Section(
        "Apresentação",
        listOf(
            Content.Video("Apresentação e Objetivos", videoLink),
            Content.Video("Introdução ao Kotlin", videoLink),
            Content.Video("Documentação Oficial e Instalação do Kotlin", videoLink),
            Content.Video("Porque o Kotlin", videoLink),
            Content.Video("Conclusão e Comentários Finais", videoLink),
        )
    )

    val ecKnowKotlin = EducationalContent(
        "Code Update TQI - Backend com Kotlin e Java",
        1,
        Level.BASIC,
        listOf(ecsKnowKotlinSection1)
        )

    val f1 = Formation(
        "Code Update TQI - Backend com Kotlin e Java",
        Level.INTERMEDIARY,
        LocalDate.of(2023,Month.NOVEMBER, 29),
        listOf(ecKnowKotlin, ecIntroKotlin).toMutableList()
        )

    val u1 = User("Joao")
    val u2 = User("Maria")

    u1.enroll(f1)
    f1.enroll(u1)

    u2.enroll(f1)
    f1.enroll(u2)

    println(u1)
}