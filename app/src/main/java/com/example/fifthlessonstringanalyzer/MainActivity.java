package com.example.fifthlessonstringanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // поля
    // строка для анализа
    private String poem = "У лукоморья дуб зелёный;\nЗлатая цепь на дубе том:\nИ днём и ночью кот учёный\n" +
            "Всё ходит по цепи кругом;\nИдёт направо — песнь заводит,\nНалево — сказку говорит.\nТам чудеса: там леший бродит,\n" +
            "Русалка на ветвях сидит;\nТам на неведомых дорожках\nСледы невиданных зверей;\nИзбушка там на курьих ножках\n" +
            "Стоит без окон, без дверей;\nТам лес и дол видений полны;\nТам о заре прихлынут волны\nНа брег песчаный и пустой,\n" +
            "И тридцать витязей прекрасных\nЧредой из вод выходят ясных,\nИ с ними дядька их морской;\nТам королевич мимоходом\n" +
            "Пленяет грозного царя;\nТам в облаках перед народом\nЧерез леса, через моря\nКолдун несёт богатыря;\nВ темнице там царевна тужит,\n" +
            "А бурый волк ей верно служит;\nТам ступа с Бабою Ягой\nИдёт, бредёт сама собой,\nТам царь Кащей над златом чахнет;\n" +
            "Там русский дух… там Русью пахнет!\nИ там я был, и мёд я пил;\nУ моря видел дуб зелёный;\nПод ним сидел, и кот учёный\nСвои мне сказки говорил.\n";

    private int numberOfCharacters; // число символов в строке
    private int numberOfWords; // число слов в строке
    private int numberOfCharactersЛ; // число букв "л" в строке
    private boolean itsAFiveLetterWord; // наличие слова из 5 букв
    private String wordsCharactersА; // строка из слов начинающихся на букву "а"

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView infoApp; // поле вывода информации анализа строки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = numberOfCharacters(poem);
        numberOfWords = numberOfWords(poem);
        numberOfCharactersЛ = numberOfCharactersЛ(poem);
        itsAFiveLetterWord = itsAFiveLetterWord(poem);
        wordsCharactersА = wordsCharactersА(poem);

        // привязка поля к разметке по id
        infoApp = findViewById(R.id.infoApp);

        // вывод информации на экран смартфона
        infoApp.setText("Число символов в строке " + numberOfCharacters + "\n"
                + "Число слов в строке " + numberOfWords + "\n"
                + "Число букв \"л\" в строке " + numberOfCharactersЛ + "\n"
                + "Наличие слова из 5 букв " + itsAFiveLetterWord + "\n"
                + "Строка из слов начинающихся на букву \"а\" " + wordsCharactersА);
    }

    // модуль компоновки строки из слов на букву "а" строки задачи
    private String wordsCharactersА(String stringPoem) {
        String stringА = ""; // строка из слов на букву "а" строки задачи
        String stPoem = stringPoem.replace("\n", "").trim(); // замена всех переходов на следующую строку пробелами, затем удаление начальных и конечных пробелов
        String[] arrayPoem = stPoem.split(" "); // деление строки на подстроки по пробелу

        for (String string : arrayPoem) { // перебор всех слов массива
            if (string.charAt(0) == 'а' | string.charAt(0) == 'А') { // если первый символ строки буква "а"
                stringА += string + " "; // то прибавление к целевой строке данного слова с разделяющим пробелом в конце
            }
        }
        return stringА.trim(); // возврат требуемого значения с удалением пробела на конце
    }

    // модуль определения наличия в строке слов из 5 букв
    private boolean itsAFiveLetterWord(String stringPoem) {
        int isWord = stringPoem.indexOf(5); // определение количество слов из 5 букв в строке
        if (isWord == -1) { // если слово не найдено
            return false;
        } else { // иначе
            return true;
        }
    }

    // модуль определения числа букв "л" в строке
    private int numberOfCharactersЛ(String stringPoem) {
        int count = 0; // счётчик числа слов в строке
        // цикл перебора символов в строке
        for (int i = 0; i < stringPoem.length(); i++) {
            if (stringPoem.charAt(i) == 'л') { // если символов с индексом i является буквой "л"
                count++;
            }
        }
        return count;
    }

    // модуль определения числа слов в строке
    private int numberOfWords(String stringPoem) {
        String stPoem = stringPoem.trim(); // удаление начальных и конечных пробелов
        int count = 0; // счётчик числа слов в строке
        // цикл перебора символов в строке
        for (int i = 0; i < stPoem.length(); i++) {
            if (stPoem.charAt(i) == ' ' | stPoem.charAt(i) == '\n') { // если символ с индексом i является пробелом или переходом в следующую строку
                count++;
            }
        }
        return count;
    }

    // модуль определения количества символов в строке
    private int numberOfCharacters(String stringPoem) {
        return  stringPoem.length();
    }
}