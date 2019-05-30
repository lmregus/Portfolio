class Singleton:
    """
    Represents a singleton class that must be used only internally
    and not outside this module.
    """
    _instance = None

    def __str__(self):
        return "I am a singleton!"

    def __new__(cls, *args, **kwargs):
        if cls._instance is None:
            cls._instance = super(Singleton, cls).__new__(cls, *args, **kwargs)
        return cls._instance

    def some_action(self):
        return "Some Action!"
