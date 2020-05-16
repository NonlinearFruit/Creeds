rm creeds/*.json
rm app/src/main/res/raw/*.json
svn checkout https://github.com/NonlinearFruit/Creeds.json/trunk/creeds
cp creeds/* app/src/main/res/raw/
rm creeds/*.json

