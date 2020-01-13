from django.shortcuts import render

# Create your views here.
# write함수는 request를 인자로 한다.
# 사용자의 요청이 request에 담긴다
def write(request):
    return render(request, 'write.html')