from singleton_meta_thread_safe import SingletonMeta


class Singleton(metaclass=SingletonMeta):
    """
    Represents a singleton class that must be used only internally
    and not outside this module.
    """
    _instance = None
    def __init__(self, value) -> None:
        self.value = value

    def __str__(self) -> str:
        return "I am a singleton!"

    def some_action(self) -> str:
        return "Some Action!"
