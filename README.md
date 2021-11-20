### Bring a local folder to remote git repo

```git
 git init
 git add .
 git commit -m "First commit"
```

Sets the new remote

```git
git remote add origin <remote repository URL>
```

Verifies the new remote URL

```git
git remote -v
```

Push the changes in your local repository to GitHub if there is a remote branch called master (or main if that's what
you're using)
```git
git push origin master
```
Otherwise you will have to name local branch first by
```git
git branch -m <new_name>
```
and then push it to add a new branch called <new_name>
```git
git push origin -u <new_name>
```