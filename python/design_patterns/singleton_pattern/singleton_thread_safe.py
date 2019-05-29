from threading import Lock


class _Singleton:
    """
    Represents a singleton class that must be used only internally
    and not outside this module.
    """

    def __init__(self, value) -> None:
        self.value = value

    def __str__(self) -> str:
        return "I am a singleton!"

    def some_action(self) -> str:
        return "Some Action!"


_instance = None
_lock: Lock = Lock()


def Singleton(value: str) -> _Singleton:
    """
    Creates a singleton instance and is thread safe.
    """
    global _instance
    global _lock

    # Makes the singleton thread safe by acquiring the lock
    # before creating the instance
    with _lock:
        if _instance is None:
            _instance = _Singleton(value)
    return _instance
