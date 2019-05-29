class _Singleton:
    """
    Represents a singleton class that must be used only internally
    and not outside this module.
    """

    def __str__(self):
        return "I am a singleton!"

    def some_action(self):
        return "Some Action!"


_instance = None


def Singleton():
    """
    Creates a singleton instance.
    """
    global _instance

    if _instance is None:
        _instance = _Singleton()
    return _instance
