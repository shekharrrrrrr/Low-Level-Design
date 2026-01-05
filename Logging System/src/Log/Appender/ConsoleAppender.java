package Log.Appender;

class ConsoleAppender implements OutputAppender {

    @Override
    public boolean write(String message) {
        System.out.println(message);
        return true;
    }
}