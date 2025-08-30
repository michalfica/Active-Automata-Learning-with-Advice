#!/bin/bash
set -e

# Ensure submodules are up to f135932 commit 
git submodule update --init --recursive
cd learnlib
git reset --hard f135932
cd ../

# Apply the patch
echo "Applying LearnLib customizations..."
patch -p1 -d learnlib < patches/file.patch

echo "LearnLib has been patched successfully."
