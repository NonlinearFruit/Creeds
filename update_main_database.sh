file="app/src/main/java/com/nonlinearfruit/creeds/main/MainDatabase.kt"
jsons="app/src/main/res/raw/"

echo -e "package com.nonlinearfruit.creeds.main\n\nimport com.nonlinearfruit.creeds.R\nimport com.nonlinearfruit.creeds.canon.CanonActivity\nimport com.nonlinearfruit.creeds.catechism.CatechismActivity\nimport com.nonlinearfruit.creeds.creed.CreedActivity\nimport com.nonlinearfruit.creeds.henryscatechism.HenrysCatechismActivity\nimport com.nonlinearfruit.creeds.main.models.MainMenuItem\nimport com.nonlinearfruit.creeds.confession.ConfessionActivity\n\nclass MainDatabase {\n\n        val mainMenuItems: List<MainMenuItem> = listOf(" > $file;

for json in $(ls $jsons); do
  jq '.Metadata | "MainMenuItem( \"\(.Title)\", \(.Year), \"\", \(.CreedFormat)Activity::class.java, R.raw.\(input_filename)),"' "${jsons}${json}" --raw-output | sed "s%${jsons}%%" | sed "s/.json//" >> $file;
done;

sed -i '$ s/.$//' $file;

echo -e ")}" >> $file;
