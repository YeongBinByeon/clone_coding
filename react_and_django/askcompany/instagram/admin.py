from django.contrib import admin
from .models import Post

# Register your models here.
#admin.site.register(Post)

@admin.register(Post)
class PostAdmin(admin.ModelAdmin):
    list_display = ['id', 'message', 'message_length', 'is_public', 'created_at', 'updated_at']
    list_display_links = ['message']
    search_fields = ['message']
    list_filter = ['message', 'is_public']
    
    def message_length(self, kkkk):
        #return len(kkkk.message)
        return f"{len(kkkk.message)} 글자"