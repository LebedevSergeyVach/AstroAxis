package astro.axis.planet.libgdx.helper

import java.util.*

class PlanetDataArray {
    private val dataMercury = arrayOf(
        "Меркурий", "2,439 км", "3.302 × 10²³ кг", "5,427 кг/м³",
        "-35°C до 187°C", "0", "Нет", "58.646 км/ч", "47.870 км/ч",
        "58.65 дней", "87,97 дней", "57.910.000 км", "Нет", "Нет",
        "Нет", "Очень разреженная", "Термосфера", "Кора\nмантия\nядро",
        "Наименьшая планета Солнечной системы\nВысокая доля железа в составе\nЗначительные температурные колебания"
    )

    private val dataVenus = arrayOf(
        "Венера", "6,051 км", "4.867 × 10²⁴ кг", "5,243 кг/м³", "462°C",
        "Нет", "Нет", "6.520 км/ч", "35.020 км/ч", "243 дня", "224,70 дней",
        "108.200.000 км", "Нет", "Нет", "Нет", "Есть", "Тропосфера\nстратосфера\nмезосфера\nтермосфера",
        "Кора\nмантия\nядро", "Вторая планета от Солнца\nСамая горячая планета\nПлотная атмосфера из углекислого газа\nОблака из серной кислоты\nОбратное вращение"
    )

    private val dataEarth = arrayOf(
        "Земля", "6,371 км", "5.972 × 10²⁴ кг", "5,515 г/см³", "14°C", "1", "Луна",
        "1,674 км/ч", "107.2 км/ч", "23 часа 56 мин", "365.25 дней", "149.600.000 км", "Нет", "Нет", "Нет",
        "Есть", "Тропосфера\nСтратосфера\nМезосфера\nТермосфера\nЭкзосфера", "Кора\nмантия\nядро",
        "Живые существа\nАтмосфера с кислородом\nИзменения климата"
    )

    private val dataMars = arrayOf(
        "Марс", "3,390 км", "6.417 × 10²³ кг", "3,933 кг/м³", "-87°C", "2", "Фобос Деймос",
        "240.077 км/ч", "24.077 км/ч", "1.026 дней", "687 дней", "227.940.000 км", "Нет", "Нет", "Нет",
        "Очень разреженная", "Тропосфера\nстратосфера", "Кора\nмантия\nядро",
        "Красная почва\nТонкая атмосфера\nПолярные шапки\nДвойная система спутников"
    )

    private val dataJupiter = arrayOf(
        "Юпитер", "69,911 км", "1.898 × 10²⁷ кг", "1,326 кг/м³", "-145°C", "79", "Европа Каллисто Ио Ганимед",
        "12.684 км/ч", "13.062 км/ч", "9.925 часов", "11.862 земных года", "778.340.000 км", "Есть", "4 основных", "Газовый гигант",
        "Есть", "Тропосфера\nСтратосфера\nМезосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
        "Самая большая планета в Солнечной системе\nНаличие сильного магнитного поля\nОгромные полосы и штормовые образования"
    )

    private val dataSaturn = arrayOf(
        "Сатурн", "58,232 км", "5.683 × 10²⁶ кг", "0.687 кг/м³", "-185°C", "82", "Титан Рея Диона Тефия Энцелад",
        "9.690 км/ч", "9.690 км/ч", "10.656 часов", "29.457 земных лет", "1,429.400.000 км", "Есть", "Многочисленные 7 основных", "Газовый гигант",
        "Есть", "Тропосфера\nСтратосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
        "Наличие спутника Титана с атмосферой и органическими молекулами\nНаличие спутника Энцелада с гейзерами водяного льда"
    )

    private val dataUranus = arrayOf(
        "Уран", "25,362 км", "8.681 × 10²⁵ кг", "1.270 кг/м³", "-206°C", "27", "Ариэль Умбриэль Титания Оберон",
        "6.810 км/ч", "6.810 км/ч", "17.24 часов", "84.016 земных лет", "2,870.990.000 км", "Есть", "13 основных", "Ледяной гигант",
        "Есть", "Тропосфера\nСтратосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
        "Планета вращается под углом 97.77°\nНаличие метана в атмосфере"
    )

    private val dataNeptune = arrayOf(
        "Нептун", "24,764 км", "1.024 × 10²⁶ кг", "1.638 кг/м³", "-201°C", "14", "Тритон Нерида",
        "5.436 км/ч", "5.436 км/ч", "16.11 часов", "164.79 земных лет", "4,495.100.000 км", "Есть", "5 основных", "Ледяной гигант",
        "Есть", "Тропосфера\nСтратосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
        "Метан в атмосфере\nНаличие сильных ветров и штормов\nСамая дальняя планета от Солнца"
    )

    private val theory = arrayOf(
        arrayOf("Астроном. единица", "Перевод в единицы измерения"),
        arrayOf("Парсек", "4,848 × 10-⁶"),
        arrayOf("Световой год", "4,848 × 10-⁶"),
        arrayOf("Километр", "1,496 × 10⁸"),

        arrayOf(""),
        arrayOf("Парсек", "Перевод в единицы измерения"),
        arrayOf("Астроном. единица", "206 265"),
        arrayOf("Световой год", "3,26"),
        arrayOf("Километр", "3,086 × 10¹³"),

        arrayOf(""),
        arrayOf("Световой год", "Перевод в единицы измерения"),
        arrayOf("Астроном. единица", "63 241"),
        arrayOf("Парсек", "0,306"),
        arrayOf("Километр", "9,461 × 10¹²")
    )

    fun getPlanetData(planetName: String): Array<String> {
        return when (planetName.lowercase(Locale.ROOT)) {
            "mercury" -> dataMercury
            "venus" -> dataVenus
            "earth" -> dataEarth
            "mars" -> dataMars
            "jupiter" -> dataJupiter
            "saturn" -> dataSaturn
            "uranus" -> dataUranus
            "neptune" -> dataNeptune
            else -> throw IllegalArgumentException("Invalid planet name: $planetName")
        }
    }

    fun getTheoryData(): Array<Array<String>> {
        return theory
    }
}
