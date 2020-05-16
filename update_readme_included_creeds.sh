jsons="app/src/main/res/raw/"

vim -s metadata/clear_readme_included_creeds.vim README.md

for file in $(ls --reverse $jsons); do 
  jq '.Metadata | " - [x] [\(.Title) (\(.Year))](\(.SourceUrl))"' "${jsons}${file}" --raw-output | xargs -0 -i sed -i "17i {}" README.md; 
done
