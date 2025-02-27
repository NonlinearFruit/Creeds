jsons="app/src/main/res/raw/"

vim -s metadata/clear_readme_included_creeds.vim README.md

includesSection=$(grep -n '## Included' README.md | cut -d: -f1)
includes=$(( $includesSection + 1 ))
for file in $(ls --reverse $jsons); do 
  jq '.Metadata | " - [x] [\(.Title) (\(.Year))](\(.SourceUrl))"' "${jsons}${file}" --raw-output | \
    xargs -0 -i sed -i "${includes}i {}" README.md; 
done

copyrightSection=$(grep -n '## Copyrights' README.md | cut -d: -f1)
copyrights=$(( $copyrightSection + 4 ))
for file in $(ls --reverse app/src/main/res/raw/); do 
  jq '.Metadata | select(.SourceAttribution | startswith("Public Domain") | not) | " - [\(.Title)](\(.SourceUrl)) <\(.SourceAttribution)>"' "app/src/main/res/raw/${file}" --raw-output | \
    xargs -0 -i sed -i "${copyrights}i {}" README.md; 
done
