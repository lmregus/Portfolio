from threading import Lock


class Singleton:
    """
    Represents a singleton class that must be used only internally
    and not outside this module.
    """
    __instance = None
    __lock: Lock = Lock()

    def __init__(self) -> None:
        self.value = value

    def __str__(self) -> str:
        return "I am a singleton!"

    def __new__(cls, *args, **kwargs):

        # Makes the singleton thread safe by acquiring the lock
        # before creating the instance
        with cls.__lock:
            if cls.__instance is None:
                cls.__isntance = super(Singleton, cls).__new__(cls, *args, **kwargs)
        return cls.__instance


    def some_action(self) -> str:
        return "Some Action!"
