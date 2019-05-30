from singleton import Singleton
from singleton_thread_safe import Singleton as SingletonThreadSafe
from threading import Thread


class TestSingleton:
    """
    This class is used to test that only one instance of the Singleton class is
    created at any given time
    """

    def test_singleton(self) -> None:
        first_instance = Singleton()
        second_instance = Singleton()

        assert id(first_instance) == id(second_instance)

    def test_singleton_thread_safe(self) -> None:
        def test_singleton(value: str) -> str:
            """
            Inner function used to confirm that the singleton is thread safe.
            If the print.value is the same for both processes, it passed.
            """
            singleton = SingletonThreadSafe()
            return singleton

        process1 = Thread(target=test_singleton, args=("process1",))
        process2 = Thread(target=test_singleton, args=("process2",))
        process1.start()
        process2.start()
