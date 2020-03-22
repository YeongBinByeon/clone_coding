class YearConverter:
    #regex = r"20\d{2}"
    regex = r"\d{4}"

    # url로부터 정규표현식으로 추출한 문자열을 뷰에 넘겨주기 전에 변환
    def to_python(self, value):
        return int(value)

    # url reverse 시에 호출
    def to_url(self, value):
        return "%04d" % value

class MonthConverter(YearConverter):
    regex = r"\d{2}" # "02" -> 2로 변환됌

class DayConverter(YearConverter):
    regex = r"[0123]\d" # 첫번째 숫자는 0123중 하나 나오고, 그다음 숫자 하나 나온다는 의미