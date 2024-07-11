from communication import SmsSender


class TestableSmsSender(SmsSender):
    def __init__(self):
        self.__send_method_is_called = None

    def send(self, schedule):
        print("테스트용 SmsSender에서 send 메서드 실행됨")
        self.__send_method_is_called = True

    def is_send_method_called(self):
        return self.__send_method_is_called
