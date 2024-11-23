// Класс для управления телевизором
class TV {
    public void turnOn() {
        System.out.println("Телевизор включен");
    }

    public void turnOff() {
        System.out.println("Телевизор выключен");
    }

    public void setChannel(int channel) {
        System.out.println("Канал установлен на " + channel);
    }
}

// Класс для управления аудиосистемой
class AudioSystem {
    public void turnOn() {
        System.out.println("Аудиосистема включена");
    }

    public void turnOff() {
        System.out.println("Аудиосистема выключена");
    }

    public void setVolume(int volume) {
        System.out.println("Громкость установлена на " + volume);
    }
}

// Класс для управления DVD-проигрывателем
class DVDPlayer {
    public void play() {
        System.out.println("DVD проигрыватель начал воспроизведение");
    }

    public void pause() {
        System.out.println("DVD проигрыватель поставлен на паузу");
    }

    public void stop() {
        System.out.println("DVD проигрыватель остановлен");
    }
}

// Класс для управления игровой консолью
class GameConsole {
    public void turnOn() {
        System.out.println("Игровая консоль включена");
    }

    public void startGame(String gameName) {
        System.out.println("Игра " + gameName + " запущена");
    }
}

// Фасад для управления мультимедийной системой
class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(TV tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    // Метод для просмотра фильма
    public void watchMovie() {
        System.out.println("Подготовка к просмотру фильма...");
        tv.turnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(10);
        dvdPlayer.play();
    }

    // Метод для игры
    public void playGame(String gameName) {
        System.out.println("Подготовка к игре...");
        tv.turnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(5);
        gameConsole.turnOn();
        gameConsole.startGame(gameName);
    }

    // Метод для выключения системы
    public void turnOffSystem() {
        System.out.println("Выключение системы...");
        tv.turnOff();
        audioSystem.turnOff();
        dvdPlayer.stop();
        gameConsole.turnOn();
    }
}

// Главный класс для демонстрации работы фасада
public class Main {
    public static void main(String[] args) {
        // Создаем объекты для каждой подсистемы
        TV tv = new TV();
        AudioSystem audioSystem = new AudioSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();

        // Создаем фасад, который управляет всей системой
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audioSystem, dvdPlayer, gameConsole);

        // Используем фасад для разных сценариев
        homeTheater.watchMovie();
        homeTheater.turnOffSystem();

        homeTheater.playGame("The Witcher 3");
        homeTheater.turnOffSystem();
    }
}
