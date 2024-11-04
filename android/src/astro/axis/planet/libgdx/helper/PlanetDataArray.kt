package astro.axis.planet.libgdx.helper

import android.content.Context
import android.content.res.Configuration
import java.util.*

class PlanetDataArray(private val context: Context) {

    private val dataMercuryEn = arrayOf(
        "Mercury", "2,439 km", "3.302 × 10²³ kg", "5,427 kg/m³",
        "-35°C to 187°C", "0", "No", "58.646 km/h", "47.870 km/h",
        "58.65 days", "87.97 days", "57,910,000 km", "No", "No",
        "No", "Very thin", "Thermosphere", "Crust mantle core",
        "Smallest planet in the Solar System High iron content Significant temperature fluctuations"
    )

    private val dataVenusEn = arrayOf(
        "Venus", "6,051 km", "4.867 × 10²⁴ kg", "5,243 kg/m³", "462°C",
        "No", "No", "6,520 km/h", "35,020 km/h", "243 days", "224.70 days",
        "108,200,000 km", "No", "No", "No", "Yes", "Troposphere stratosphere mesosphere thermosphere",
        "Crust mantle core", "Second planet from the Sun Hottest planet Dense CO₂ atmosphere Sulfuric acid clouds Retrograde rotation"
    )

    private val dataEarthEn = arrayOf(
        "Earth", "6,371 km", "5.972 × 10²⁴ kg", "5,515 g/cm³", "14°C", "1", "Moon",
        "1,674 km/h", "107.2 km/h", "23 hours 56 min", "365.25 days", "149,600,000 km", "No", "No", "No",
        "Yes", "Troposphere Stratosphere Mesosphere Thermosphere Exosphere", "Crust mantle core",
        "Living beings Oxygen atmosphere Climate change"
    )

    private val dataMarsEn = arrayOf(
        "Mars", "3,390 km", "6.417 × 10²³ kg", "3,933 kg/m³", "-87°C", "2", "Phobos Deimos",
        "240,077 km/h", "24,077 km/h", "1.026 days", "687 days", "227,940,000 km", "No", "No", "No",
        "Very thin", "Troposphere stratosphere", "Crust mantle core",
        "Red soil Thin atmosphere Polar caps Double satellite system"
    )

    private val dataJupiterEn = arrayOf(
        "Jupiter", "69,911 km", "1.898 × 10²⁷ kg", "1,326 kg/m³", "-145°C", "79", "Europa Callisto Io Ganymede",
        "12,684 km/h", "13,062 km/h", "9.925 hours", "11.862 Earth years", "778,340,000 km", "Yes", "4 main", "Gas giant",
        "Yes", "Troposphere Stratosphere Mesosphere Thermosphere", "Hot mantle zone core",
        "Largest planet in the Solar System Strong magnetic field Huge bands and storm formations"
    )

    private val dataSaturnEn = arrayOf(
        "Saturn", "58,232 km", "5.683 × 10²⁶ kg", "0.687 kg/m³", "-185°C", "82", "Titan Rhea Dione Tethys Enceladus",
        "9,690 km/h", "9,690 km/h", "10.656 hours", "29.457 Earth years", "1,429,400,000 km", "Yes", "Numerous 7 main", "Gas giant",
        "Yes", "Troposphere Stratosphere Thermosphere", "Hot mantle zone core",
        "Titan has an atmosphere and organic molecules Enceladus has water ice geysers"
    )

    private val dataUranusEn = arrayOf(
        "Uranus", "25,362 km", "8.681 × 10²⁵ kg", "1.270 kg/m³", "-206°C", "27", "Ariel Umbriel Titania Oberon",
        "6,810 km/h", "6,810 km/h", "17.24 hours", "84.016 Earth years", "2,870,990,000 km", "Yes", "13 main", "Ice giant",
        "Yes", "Troposphere Stratosphere Thermosphere", "Hot mantle zone core",
        "Planet rotates at an angle of 97.77° Methane in the atmosphere"
    )

    private val dataNeptuneEn = arrayOf(
        "Neptune", "24,764 km", "1.024 × 10²⁶ kg", "1.638 kg/m³", "-201°C", "14", "Triton Nereid",
        "5,436 km/h", "5,436 km/h", "16.11 hours", "164.79 Earth years", "4,495,100,000 km", "Yes", "5 main", "Ice giant",
        "Yes", "Troposphere Stratosphere Thermosphere", "Hot mantle zone core",
        "Methane in the atmosphere Strong winds and storms Farthest planet from the Sun"
    )

    private val dataMercuryRu = arrayOf(
        "Меркурий", "2,439 км", "3.302 × 10²³ кг", "5,427 кг/м³",
        "-35°C до 187°C", "0", "Нет", "58.646 км/ч", "47.870 км/ч",
        "58.65 дней", "87,97 дней", "57.910.000 км", "Нет", "Нет",
        "Нет", "Очень разреженная", "Термосфера", "Кора мантия ядро",
        "Наименьшая планета Солнечной системы Высокая доля железа в составе Значительные температурные колебания"
    )

    private val dataVenusRu = arrayOf(
        "Венера", "6,051 км", "4.867 × 10²⁴ кг", "5,243 кг/м³", "462°C",
        "Нет", "Нет", "6.520 км/ч", "35.020 км/ч", "243 дня", "224,70 дней",
        "108.200.000 км", "Нет", "Нет", "Нет", "Есть", "Тропосфера стратосфера мезосфера термосфера",
        "Кора мантия ядро", "Вторая планета от Солнца Самая горячая планета Плотная атмосфера из углекислого газа Облака из серной кислоты Обратное вращение"
    )

    private val dataEarthRu = arrayOf(
        "Земля", "6,371 км", "5.972 × 10²⁴ кг", "5,515 г/см³", "14°C", "1", "Луна",
        "1,674 км/ч", "107.2 км/ч", "23 часа 56 мин", "365.25 дней", "149.600.000 км", "Нет", "Нет", "Нет",
        "Есть", "Тропосфера Стратосфера Мезосфера Термосфера Экзосфера", "Кора мантия ядро",
        "Живые существа Атмосфера с кислородом Изменения климата"
    )

    private val dataMarsRu = arrayOf(
        "Марс", "3,390 км", "6.417 × 10²³ кг", "3,933 кг/м³", "-87°C", "2", "Фобос Деймос",
        "240.077 км/ч", "24.077 км/ч", "1.026 дней", "687 дней", "227.940.000 км", "Нет", "Нет", "Нет",
        "Очень разреженная", "Тропосфера стратосфера", "Кора мантия ядро",
        "Красная почва Тонкая атмосфера Полярные шапки Двойная система спутников"
    )

    private val dataJupiterRu = arrayOf(
        "Юпитер", "69,911 км", "1.898 × 10²⁷ кг", "1,326 кг/м³", "-145°C", "79", "Европа Каллисто Ио Ганимед",
        "12.684 км/ч", "13.062 км/ч", "9.925 часов", "11.862 земных года", "778.340.000 км", "Есть", "4 основных", "Газовый гигант",
        "Есть", "Тропосфера Стратосфера Мезосфера Термосфера", "Горячая мантийная зона ядро",
        "Самая большая планета в Солнечной системе Наличие сильного магнитного поля Огромные полосы и штормовые образования"
    )

    private val dataSaturnRu = arrayOf(
        "Сатурн", "58,232 км", "5.683 × 10²⁶ кг", "0.687 кг/м³", "-185°C", "82", "Титан Рея Диона Тефия Энцелад",
        "9.690 км/ч", "9.690 км/ч", "10.656 часов", "29.457 земных лет", "1,429.400.000 км", "Есть", "Многочисленные 7 основных", "Газовый гигант",
        "Есть", "Тропосфера Стратосфера Термосфера", "Горячая мантийная зона ядро",
        "Наличие спутника Титана с атмосферой и органическими молекулами Наличие спутника Энцелада с гейзерами водяного льда"
    )

    private val dataUranusRu = arrayOf(
        "Уран", "25,362 км", "8.681 × 10²⁵ кг", "1.270 кг/м³", "-206°C", "27", "Ариэль Умбриэль Титания Оберон",
        "6.810 км/ч", "6.810 км/ч", "17.24 часов", "84.016 земных лет", "2,870.990.000 км", "Есть", "13 основных", "Ледяной гигант",
        "Есть", "Тропосфера Стратосфера Термосфера", "Горячая мантийная зона ядро",
        "Планета вращается под углом 97.77° Наличие метана в атмосфере"
    )

    private val dataNeptuneRu = arrayOf(
        "Нептун", "24,764 км", "1.024 × 10²⁶ кг", "1.638 кг/м³", "-201°C", "14", "Тритон Нерида",
        "5.436 км/ч", "5.436 км/ч", "16.11 часов", "164.79 земных лет", "4,495.100.000 км", "Есть", "5 основных", "Ледяной гигант",
        "Есть", "Тропосфера Стратосфера Термосфера", "Горячая мантийная зона ядро",
        "Метан в атмосфере Наличие сильных ветров и штормов Самая дальняя планета от Солнца"
    )

    private val theoryEn = arrayOf(
        arrayOf("Astronomical unit", "Conversion to units of measurement"),
        arrayOf("Parsec", "4.848 × 10-⁶"),
        arrayOf("Light-year", "4.848 × 10-⁶"),
        arrayOf("Kilometer", "1.496 × 10⁸"),

        arrayOf(""),
        arrayOf("Parsec", "Conversion to units of measurement"),
        arrayOf("Astronomical unit", "206,265"),
        arrayOf("Light-year", "3.26"),
        arrayOf("Kilometer", "3.086 × 10¹³"),

        arrayOf(""),
        arrayOf("Light-year", "Conversion to units of measurement"),
        arrayOf("Astronomical unit", "63,241"),
        arrayOf("Parsec", "0.306"),
        arrayOf("Kilometer", "9.461 × 10¹²")
    )

    private val theoryRu = arrayOf(
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

    private fun isRussianLocale(): Boolean {
        val locale = context.resources.configuration.locale
        return locale.language == "ru"
    }

    fun getPlanetData(planetName: String): Array<String> {
        val data = when (planetName.lowercase(Locale.ROOT)) {
            "mercury" -> if (isRussianLocale()) dataMercuryRu else dataMercuryEn
            "venus" -> if (isRussianLocale()) dataVenusRu else dataVenusEn
            "earth" -> if (isRussianLocale()) dataEarthRu else dataEarthEn
            "mars" -> if (isRussianLocale()) dataMarsRu else dataMarsEn
            "jupiter" -> if (isRussianLocale()) dataJupiterRu else dataJupiterEn
            "saturn" -> if (isRussianLocale()) dataSaturnRu else dataSaturnEn
            "uranus" -> if (isRussianLocale()) dataUranusRu else dataUranusEn
            "neptune" -> if (isRussianLocale()) dataNeptuneRu else dataNeptuneEn
            else -> throw IllegalArgumentException("Invalid planet name: $planetName")
        }
        return data
    }

    fun getTheoryData(): Array<Array<String>> {
        return if (isRussianLocale()) theoryRu else theoryEn
    }
}
