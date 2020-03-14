from django.db import models

# models.ImageField 사용 위해 아래 라이브러리 설치 필요(파이썬 이미징 라이브러리)
# python -m pip install Pillow

# Create your models here.
class Post(models.Model):
    message = models.TextField()
    photo = models.ImageField(blank=True, upload_to='instagram/post/%Y/%m/%d')
    is_public = models.BooleanField(default=False, verbose_name='공개여부')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    # Java의 toString
    def __str__(self):
        # 파이썬 3.7부터 지원되는 문법
        #return f"Custom Post object ({self.id})"
        # 파이썬 3.7 이전에서 사용하려면 아래와 같이
        #return "Custom Post object ({})".format(self.id)
        return self.message

    class Meta:
        ordering = ['-id']
    
    # def message_length(self):
    #     return len(self.message)
    # message_length.short_description = "메세지 글자수"