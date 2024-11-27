# LearnConnect

Bu uygulamada android tasarım örüntülerinden MVVM kullananıldı. Veri tabanı olarak Room Database üzerinde işlemler yapıldı. işlemlerin kullanıcı arayüzünü kitlememesi için Kotlin Coroutines yapısını birkaç yerde kullanıldı. Sayfalar arası geçişleri Navigation Component, sayfalar arası veri alışverişi için Safe Args yapısı tercih edildi. Uygulama içi bağımlılıklar Hilt ile sağlandı.

## Uygulamanın Bilgileri

RoomDB başlatılınca edilince uygulama içincde belirtilen initializer sınıflar Db içine dummy veriler ekler.

Her ekran için ViewModel, Fragment, State gibi yardımcı sınıflar kullanıldı.

Uygulama Wishlist, User, Course, Video, VideoProgress, UserVideo gibi tablolar ile yönetilir.

Kullanıcı uygulamaya kayıt olmadan içerikler sunulmaz, ve kursa kaydolmadan kurs içeriği aktif olmaz.

## XML yapısı ve kullanılan yapılar
Her bir XML sayfası ve Kotlin sayfası ViewBinding ve/ ve ya DataBinding gibi yapılar ile kodlanmış. Aynı zamanda XML sayfalarında ConstraintLayout, RecyclerView sınıfını kullanarak da görüntüleme işlemlerini gerçekleştirildi.

## Projede eksik kalan kısımlar
Birim Testler