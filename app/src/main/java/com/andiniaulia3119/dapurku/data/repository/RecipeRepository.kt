package com.andiniaulia3119.dapurku.data.repository

import com.andiniaulia3119.dapurku.data.model.Recipe

object RecipeRepository {
    private val recipes = mutableListOf<Recipe>()

    init {
        initializeDummyData()
    }

    private fun initializeDummyData() {
        recipes.addAll(
            listOf(
                Recipe(
                    id = 1,
                    name = "Nasi Goreng",
                    type = "Makanan Berat",
                    description = "Bahan-bahan yang diperlukan:" +
                    "\n- 1 buah paha ayam atas bawah rebus, suwir ayamnya" +
                    "\n 2 buah telur, kocok lepas" +
                    "\n 150 g udang tanpa kulit" +
                    "\n 5 buah bakso sapi, potong-potong" +
                    "\n 5 buah bakso ikan, potong-potong" +
                    "\n 500 g nasi putih" +
                    "\n 2 sdm kecap manis" +
                    "\n 1 sdt garam" +
                    "\n 1/2 sdt gula pasir" +
                    "\n 1 buah daun bawang, iris tipis" +
                    "\n 1 1/2 sdm bawang goreng untuk taburan" +
                    "\n 3 sdm minyak goreng untuk menumis" +
                    "\n 1 sdt terasi, bakar" +
                    "\n 3 buah cabai merah besar" +
                    "\n 3 buah cabai merah keriting" +
                    "\n 2 siung bawang putih" +
                    "\n 6 butir bawang merah" +
                    "\n 3 buah telur ceplook" +
                            "\n" +
                    "\n Langkah-langkah pembuatan:" +
                    "\n 1. Panaskan minyak. Tumis bumbu tumbuk kasar sampai harum. Sisihkan di pinggir wajan. Masukkan telur. Aduk sampai berbutir." +
                    "\n 2. Tambahkan ayam, udang, bakso. Aduk rata. Tambahkan nasi putih. Aduk- aduk. Masukkan kecap manis, garam, dan gula pasir. Aduk sampai matang." +
                    "\n 3. Masukkan daun bawang. Aduk rata. Sajikan bersama telur ceplok dan taburan bawang merah goreng."
                ),
                Recipe(
                    id = 2,
                    name = "Sate Ayam",
                    type = "Makanan Berat",
                    description = "Bahan-bahan yang diperlukan:" +
                    "\n 1 ekor dada ayam" +
                    "\n 2 sdm gula merah" +
                    "\n garam secukupnya" +
                    "\n kaldu bubuk secukupnya" +
                    "\n 2 sdm mentega" +
                    "\n 3 sdm kecap manis" +
                    "\n tusuk sate secukupnya, rendam dalam air dulu" +
                    "\n 1 sdt ketumbar" +
                    "\n 2 biji kemiri" +
                    "\n 2 siung bawang putih dan merah" +
                    "\n" +
                    "\n Langkah-langkah pembuatan:" +
                    "\n 1. Siapkan bumbu\n" +
                            "     Sisir gula merah\n" +
                            "     Potong² ayam persegi, beri perasan jeruk nipis, cuci bersih" +
                    "\n 2. Campurkan bumbu halus, ayam, gula merah, kecap, garam, mentega dan kaldu bubuk, aduk rata, diamkan kurang lebih 2 jam atau semalaman di kulkas." +
                    "\n 3. Tusuk sate dengan lidi, kemudian bakar sambil di olesi bumbu baceman tadi, bolak balik hingga matang." +
                    "\n 4. Siap disajikan dengan pelengkapnya."
                ),
                Recipe(
                    id = 3,
                    name = "Risoles",
                    type = "Makanan Ringan",
                    description = "Bahan-bahan yang diperlukan:" +
                    "\n 1. 250 tepung terigu protein sedang" +
                    "\n 2. 2 sdm tepung tapioka / tepung aci" +
                    "\n 3. 1 sachet susu bubuk dancow putih" +
                    "\n 4. 1 butir telur" +
                    "\n 5. 1 sdm minyak goreng bersih" +
                    "\n 6. 1/2 sdt garam" +
                    "\n 7. 500 ml air" +
                    "\n 8. 200 gr mayonaise" +
                    "\n 9. 35 gr keju cheddar di parut" +
                    "\n 10. 1 sachet kental manis" +
                    "\n 11. secukupnya larutan tepung terigu" +
                    "\n 12. secukupnya tepung roti" +
                    "\n 13. secukupnya minyak" +
                    "\n " +
                    "\n Langkah-langkah pembuatan:" +
                    "\n 1. Buat kulit risol : Campur seluruh bahan kulit kecuali air. Tambahkan air sedikit demi sedikit sambil mengaduk adonan, sisakan sedikit airnya (sekitar 100 ml)." +
                    "\n 2. Saring adonan kulit, untuk melarutkan sisa tepung yang ada di saringan, tambahkan sisa air yang tadi. Tutup adonan dan diamkan selama 30 menit." +
                    "\n 3. Panaskan wajan anti lengket (saya diameter 20cm), kemudian tuang 1 sendok sayur adonan, dan bentuk dadar. Masak hingga kulit risol terlepas dari wajan. Lakukan hingga seluruh adonan habis. Agar tidak kering tutup kulit risol selagi kita buat isian mayonaise nya." +
                    "\n 4. Campurkan mayonaise, keju dan kental manis, aduk hingga tercampur rata. Siapkan sosis potong dan telur rebus potong." +
                    "\n 5. Ambil selembar kulit risol, oles dengan mayonaise, lalu susun telur dan sosis, tambahkan lagi 1 sdm mayonaise di atasnya. Lipat seperti amplop dan gulung." +
                    "\n 6. Celupkan ke dalam larutan terigu (buat larutan jangan terlalu kental), lalu gulingkan ke tepung roti (tepung roti saya haluskan lagi dengan chopper/blender). Lakukan hingga seluruh kulit risol selesai terisi. Masukkan terlebih dahulu ke dalam chiller kulkas sekitar 30 menit agar set." +
                    "\n 7. Panaskan minyak goreng (agak banyak agar risol terendam saat di goreng), lalu goreng risol dengan 1x balik. Pastikan minyaknya panas, karena jika terlalu lama menggoreng dapat membuat kulit risol merekah dan robek. Setelah matang, angkat risol dan tiriskan. Sajikan dengan saos sambal/saos tomat."
                ),
                Recipe(
                    id = 4,
                    name = "Pisang Goreng",
                    type = "Makanan Ringan",
                    description = "Bahan-bahan yang diperlukan:" +
                    "\n 1. 1 sisir pisang atau 6 buah pisang " +
                    "\n 2. 3 butir telur" +
                    "\n 3. 1 batang daun bawang" +
                    "\n 4. 2 ons tepung panir" +
                    "\n 5. minyak goreng" +
                    "\n " +
                    "\n Langkah-langkah pembuatan:" +
                    "\n 1. Potong pisang secara menyerong." +
                    "\n 2. Pecahkan telur, potong daun bawang kocok lepas." +
                    "\n 3. Campurkan telur didalam pisang aduk rata." +
                    "\n 4. Campurkan telur didalam pisang aduk rata." +
                    "\n 5. Panaskan minyak dengan api sedang, goreng pisang hingga matang, tiriskan." +
                    "\n 6. Pisang goreng siap dimakan, selamat mencoba."
                ),
                Recipe(
                    id = 5,
                    name = "Ayam Katsu",
                    type = "Makanan Berat",
                    description = "Bahan-bahan yang diperlukan:" +
                    "\n 1. 4 Potong Dada Fillet (bagi menjadi 2 bagian)" +
                    "\n 2. 6 sdm susu cair" +
                    "\n 3. 2 sdm air jeruk lemon" +
                    "\n 4. 1/4 sdt kaldu jamur" +
                    "\n 5. 1/4 sdt garam" +
                    "\n 6. 1/8 sdt lada" +
                    "\n 7. tepung panir secukupnya" +
                    "\n 8. 2 butir telur" +
                    "\n 9. 150 gr tepung terigu" +
                    "\n 10. 1/2 sdt baking powder" +
                    "\n 11. 1/2 sdt garam" +
                    "\n 12. 1/2 sdt lada" +
                    "\n 13. 1/2 sdt kaldu jamur" +
                    "\n 14. 1 sdm bawang putih bubuk" +
                    "\n " +
                    "\n Langkah-langkah pembuatan:" +
                    "\n 1. Campurkan ayam dengan susu cair, jeruk lemon, kaldu jamur, garam dan lada. Marinasi ayam semalaman." +
                    "\n 2. Campurkan telor dan susu cair ke dalam mangkuk. Aduk rata. Siaihkan." +
                    "\n 3. Campurkan tepung terigu, baking powder, bawang putih bubuk, kaldu jamur, garam dan lada ke dalam mangkuk lain. Aduk rata. Sisihkan." +
                    "\n 4. Siapkan mangkuk lain lagi. Tuang tepung panir ke dalam mangkuk." +
                    "\n 5. Masukkan ayam yang sudah dimarinasi ke dalam bahan pencelup, lalu gulingkan ke dalam adonan tepung." +
                    "\n 6. Kemudian masukkan lagi ke dalam bahan pencelup, lalu gulingkan ke dalam tepung panir hingga rata. Lakukan hingga ayam habis." +
                    "\n 7. Panaskan minyak goreng, goreng katsu dengan api sedang hingga matang merata dan berwarna kuning kecoklatan. Angkat. Sajikan."
                ),
                Recipe(
                    id = 6,
                    name = "Donat Kentang",
                    type = "Makanan Ringan",
                    description = "Bahan-bahan yang diperlukan:" +
                    "\n 1. 200 gr kentang kukus dan haluskan" +
                    "\n 2. 500 gr tepung terigu protein tinggi" +
                    "\n 3. 8 gr ragi" +
                    "\n 4. 70 gr gula pasir" +
                    "\n 5. 2 sendok makan susu bubuk" +
                    "\n 6. 4 butir kuning telur" +
                    "\n 7. 220 ml susu full cream dingin dari kulkas" +
                    "\n 8. 60 gr mentega/butter" +
                    "\n " +
                    "\n Langkah-langkah pembuatan:" +
                    "\n 1. Kukus terlebih dahulu kentang, lalu haluskan dan sisihkan." +
                    "\n 2. Campur semua bahan kedua sampai benar-benar tercampur rata." +
                    "\n 3. Apabila bahan kedua sudah tercampur rata, lalu masukkan kuning telur, aduk-aduk perlahan, apabila sudah tercampur rata ke adonan lalu tuangkan susu jangan dituang semuanya tapi perlahan-lahan saja." +
                    "\n 4. Apabila adonan sudah tercampur rata, lalu masukkan kentang, kemudian uleni kembali hingga kalis, lalu masukkan mentega dan uleni kembali hingga kalis kurang lebih 30 menit." +
                    "\n 5. Apabila sudah kalis, tutup adonan dengan kain bersih diamkan selama 40-60 menit." +
                    "\n 6. Lalu cetak adonan, dibulat-bulatkan, dan tutup kembali adonan lalu diamkan kembali 10 menit." +
                    "\n 7. Panaskan terlebih dahulu minyak goreng, apabila minyak sudah panas masukan donat yg sudah dicetak kemudian kecilkan lagi apinya"
                ),
                Recipe(
                    id = 7,
                    name = "Roti Lapis Isi",
                    type = "Makanan Ringan",
                    description = "Bahan-bahan yang diperlukan:" +
                    "\n 1. 4 lembar roti tawar" +
                    "\n 2. 2 sdm mentega" +
                    "\n 3. 3 butir telur" +
                    "\n 4. 1 buah wortel, iris halus memanjang" +
                    "\n 5. 1 genggam kol, iris halus memanjang" +
                    "\n 6. 1 batang daun bawang, iris" +
                    "\n 7. 2 lembar keju cheddar" +
                    "\n 8. 2 lembar smoked meat" +
                    "\n 9. garam dan merica bubuk secukupnya" +
                    "\n 10. mayonaise dan saus sambal secukupnya" +
                    "\n " +
                    "\n Langkah-langkah pembuatan:" +
                    "\n 1. Campur wortel, kol, daun bawang, telur, merica bubuk, dan garam. Aduk rata." +
                    "\n 2. Panaskan teflon, lelehkan 1 sdm mentega, tuang adonan telur. Masak hingga kedua sisi telur matang." +
                    "\n 3. Masak smoked meat hingga matang di kedua sisi." +
                    "\n 4. Olesi permukaan roti dengan mentega. Panggang di atas teflon hingga agak kecokelatan." +
                    "\n 5. Ambil selembar roti, lalu tata telur, smoked meat, dan keju. Beri mayonaise dan saus sambal. Tutup dengan selembar roti lagi."
                )
            )
        )
    }

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun getRecipes(): List<Recipe> = recipes

    fun getRecipeById(id: Long): Recipe? {
        return recipes.find { it.id == id }
    }
}