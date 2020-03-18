from django.urls import path, re_path, register_converter
from . import views

class YearConverter:
    regex = r"20\d{2}"

    # url로부터 정규표현식으로 추출한 문자열을 뷰에 넘겨주기 전에 변환
    def to_python(self, value):
        return int(value)

    # url reverse 시에 호출
    def to_url(self, value):
        return "%04d" % value
# https://github.com/django/django/blob/master/django/urls/converters.py
register_converter(YearConverter, 'year')

app_name = 'instagram' # URL Reverse에서 namespace 역할을 하게 된다.

urlpatterns = [
    path('', views.post_list),
    path('<int:pk>/', views.post_detail),
    path('archives/<year:year>/', views.archives_year),
    #re_path(r'archives/(?P<year>20\d{2})/', views.archives_year),
]
