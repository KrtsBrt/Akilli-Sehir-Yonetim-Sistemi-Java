Akıllı Şehir Yönetim Sistemi

Bu çalışma, kentsel kaynakların (su, enerji, trafik) dijital ortamda izlenmesi ve yönetilmesi için geliştirilmiş nesne yönelimli bir simülasyon projesidir. Temel odak noktası; statik veri yönetiminin ötesine geçerek, kaynak durumlarını analiz eden ve kriz anlarında otonom tepki veren bir sistem mimarisi kurgulamaktır.

Sistem Mimarisi ve Teknik Uygulamalar

Nesne Yönelimli Modelleme (OOP): Şehir bileşenleri (Bina, Araç, Enerji Kaynağı) birbirinden bağımsız sınıflar olarak tasarlandı. Veri bütünlüğünü sağlamak ve modülerliği korumak amacıyla her varlık kendi sorumluluk alanına göre kapsüllendi (Encapsulation).

Dinamik Veri Yönetimi ve Analiz: Sistem, şehir varlıklarını dinamik listeler üzerinden yönetir. Veriler sadece saklanmakla kalmaz; kaynak tüketim oranları ve kapasite sınırları sürekli kontrol edilerek gerçek zamanlı bir izleme altyapısı sunulur.

Exception Handling ve Kriz Senaryoları: Projenin en kritik bölümlerinden biri olan hata yönetimi, sisteme özgü geliştirilen 'Custom Exception' yapılarıyla kurgulandı. Trafik yoğunluğunun veya su rezervlerinin kritik eşiğe ulaşması durumunda, sistem otonom olarak TrafikSikisikligi veya DusukSu gibi istisnalar fırlatarak müdahale gereksinimini raporlar.

Rol Tabanlı Erişim Kontrolü: Uygulama içerisinde 'Yönetici' ve 'Vatandaş' rolleri için farklı yetkilendirme seviyeleri tanımlanmıştır. Yönetici paneli sistemin tüm parametrelerine müdahale imkanı sunarken, vatandaş arayüzü sadece bilgi akışını izlemek üzere izole edilmiştir.

Kullanıcı Arayüzü (Swing): Java Swing kütüphanesi kullanılarak, nesne tiplerine göre dinamik olarak şekillenen ve kullanıcı giriş hatalarını minimize eden interaktif bir kontrol paneli geliştirilmiştir.

Teknik Detaylar

Dil: Java

Arayüz: Java Swing

Mimari: Modüler Nesne Yönelimli Tasarım

Hata Yönetimi: Custom Runtime Exceptions
