from threading import Lock


class SingletonMeta(type):
    """
    Thread safe meta class for a Singleton
    """

    _instance: None

    _lock: Lock = Lock()

    def __call__(cls, *args, **kwargs):
        # Makes the singleton thread safe by acquiring the lock
        # before creating the instance
        with cls._lock:
            if not cls._instance:
                cls._instance = super().__call__(*args, **kwargs)
        return cls._instance
